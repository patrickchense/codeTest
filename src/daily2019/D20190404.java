package daily2019;

/*
Describe what happens when you type a URL into your browser and press Enter.
@hard
@twitch

@network

 */
public class D20190404 {

    /*
    1. find url in local memory -> dns server -> root name server -> TLD -> ANS
    2. SSL,
        request CA from site， random1
        server response CA, random2
            client get PUBLIC KEY from CA,
        server sends client something to say it's done
        client use PUBLIC KEY and random3, generate PreMaster key
        send key to server
            server decrypt key using private key, get random3
        then both side using 3 random to do sync-encryption

        server can use session to optimize the whole process
     */
}
