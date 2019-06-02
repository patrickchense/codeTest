package adyen;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBug {
    public static void main(String[] args) {
        PendingTransaction pt = new PendingTransaction();
        pt.setId(1110L);
        PendingTransaction pt1 = new PendingTransaction();
        pt1.setId(1112L);
        List<PendingTransaction> pts = new ArrayList<>();
        pts.add(pt);
        pts.add(pt1);

        ProcessedTransaction pdt = new ProcessedTransaction();
        pdt.setId("1111");
        pdt.setStatus(Optional.of("DONE"));

        ProcessedTransaction pdt1 = new ProcessedTransaction();
        pdt1.setId(null);
        pdt1.setStatus(Optional.of("DONE"));


        ProcessedTransaction pdt2 = new ProcessedTransaction();
        pdt2.setId("1113");
        pdt2.setStatus(null);

        ProcessedTransaction pdt3 = new ProcessedTransaction();
        pdt2.setId("1114");
        pdt2.setStatus(Optional.of("done"));

        List<ProcessedTransaction> pdts = new ArrayList<>();
        pdts.add(pdt);
        pdts.add(pdt1);

        List<ProcessedTransaction> pdts1 = new ArrayList<>();

        List<ProcessedTransaction> pdts2 = new ArrayList<>();
        pdts1.add(pdt2);
        pdts2.add(pdt3);

        List<Stream<ProcessedTransaction>> pdtss = new ArrayList<>();
        pdtss.add(pdts.stream());
        pdtss.add(pdts1.stream());
        pdtss.add(pdts2.stream());

        Stream<PendingTransaction> res = reconcile(pts.stream(), pdtss.stream());

        res.forEach(System.out::println);

    }

    static Stream<PendingTransaction> reconcile(Stream<PendingTransaction> pending, Stream<Stream<ProcessedTransaction>> processed) {
        if(pending == null || processed == null) {
            return Stream.empty();
        }
        List<Long>  filteredProcessedId = processed
                .flatMap(p -> p)
                .filter(Objects::nonNull)
                .filter(p -> p.getStatus() != null && p.getStatus().isPresent() && "DONE".equalsIgnoreCase(p.getStatus().get()))
                .filter(p -> p.getId() != null && p.getId().length() > 0)
                .map(p -> Long.parseLong(p.getId())).collect(Collectors.toList());

        return pending.filter(p -> filteredProcessedId.contains(p.getId()));
    }

    static class PendingTransaction {
        Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "PendingTransaction{" +
                    "id=" + id +
                    '}';
        }
    }

    static class ProcessedTransaction {
        Optional<String> status;
        String id;

        public Optional<String> getStatus() {
            return status;
        }

        public void setStatus(Optional<String> status) {
            this.status = status;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
