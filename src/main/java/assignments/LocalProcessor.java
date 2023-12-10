package assignments;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period;
    private String processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringArrayList;
    private StringBuilder stringBuilder;

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
        this.stringBuilder = new StringBuilder();
    }

    public LocalProcessor() {
        this.processorName = "Null";
        this.period = 0L;
        this.processorVersion = "0.0.0";
        this.valueOfCheap = 0;
        this.informationScanner = null;
        this.stringArrayList = new LinkedList<>();
        this.stringBuilder = new StringBuilder();
    }

    @ListIteratorAnnotation
    public void listIterator() {
        for (int i = 0; i < period; i++) {
            System.out.println(stringArrayList.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String getFullNameProcessorGenerator(LinkedList<String> list) {
        stringBuilder = new StringBuilder(processorName);
        for (String s : list) {
            stringBuilder.append(s).append(" ");
        }
        return stringBuilder.toString();
    }

    @ReadFullProcessorNameAnnotation
    public String readFullProcessorName(File file) throws FileNotFoundException {
        informationScanner = new Scanner(file);
        stringBuilder = new StringBuilder();
        while (informationScanner.hasNext()) {
            stringBuilder.append(informationScanner.nextLine());
        }
        return stringBuilder.toString();
    }
}

