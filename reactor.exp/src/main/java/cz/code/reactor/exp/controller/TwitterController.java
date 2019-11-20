package cz.code.reactor.exp.controller;

import java.awt.*;

@RestController
@RequestMapping("/api/tweets")
public class TwitterController {

	@GetMapping(path = "/filtered", produces = PageAttributes.MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> filtered() {
		ConnectableFlux<Status> flux = TwitterService.getTwitterStream();

		return flux
				.filter(status -> status.getText().contains("the"))
				.map(status -> status.getText());

	}

	@GetMapping(path = "/feed", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> feed() {
		ConnectableFlux<Status> flux = TwitterService.getTwitterStream();

		return flux.map(status -> status.getText());

	}

	@GetMapping(path = "/onePerSecond", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> onePerSecond() {
		ConnectableFlux<Status> flux = TwitterService.getTwitterStream();

		Flux<Status> filtered = flux.filter(status -> {
			Place place = status.getPlace();
			if (place != null) {
				return status.getPlace().getCountryCode().equalsIgnoreCase("us");
			}
			return false;
		});

		return filtered
				.map(status -> status.getCreatedAt().toGMTString() + " " + status.getPlace().getCountryCode() + " " + status.getText());

	}

	@GetMapping(path = "/grouped", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux grouped() {
		ConnectableFlux<Status> flux = TwitterService.getTwitterStream();

		Flux<Status> filtered = flux.filter(status -> {
			Place place = status.getPlace();
			if (place != null) {
				return status.getPlace().getCountryCode().equalsIgnoreCase("us");
			}
			return false;
		});

		return Flux.interval(Duration.ofSeconds(1))
				.zipWith(filtered, (tick, status) -> status)
				.map(status -> status.getText());
	}
}
