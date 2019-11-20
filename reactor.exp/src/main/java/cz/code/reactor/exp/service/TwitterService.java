package cz.code.reactor.exp.service;

public class TwitterService {

	private static ConnectableFlux twitterStream;

	public static synchronized ConnectableFlux getTwitterStream() {
		if (twitterStream == null) {
			initTwitterStream();
		}
		return twitterStream;
	}

	private static void initTwitterStream() {
		Flux<Status> stream = Flux.create(emitter -> {
			StatusListener listener = new StatusListener() {

				@Override
				public void onException(Exception e) {
					emitter.error(e);
				}
				@Override
				public void onDeletionNotice(StatusDeletionNotice arg) {
				}
				@Override
				public void onScrubGeo(long userId, long upToStatusId) {
				}
				@Override
				public void onStallWarning(StallWarning warning) {
				}
				@Override
				public void onStatus(Status status) {
					emitter.next(status);
				}
				@Override
				public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
					System.out.println(numberOfLimitedStatuses);
				}
			};

			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
					.setOAuthConsumerKey("YOUR_ACCESS_KEY")
					.setOAuthConsumerSecret("YOUR_ACCESS_SECRET")
					.setOAuthAccessToken("YOUR_ACCESS_TOKEN")
					.setOAuthAccessTokenSecret("YOUR_ACCESS_TOKEN_SECRET");

			TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
			twitterStream.addListener(listener);
			twitterStream.sample();

		});
		twitterStream = stream.publish();
		twitterStream.connect();
	}
}
