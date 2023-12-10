package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period;
    private String ProcessorVersion;
    private Integer valueOfCheap;
    private List<String> stringArrayList;

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        ProcessorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.stringArrayList = stringArrayList;
    }

    @ListIteratorAnnotation
    public void listIterator() {
        for (int i = 0; i < period; i++) {
            System.out.println(stringArrayList.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String getFullNameProcessorGenerator() {
        StringBuilder stringBuilder = new StringBuilder(processorName);
        for (String s : stringArrayList) {
            stringBuilder.append(s).append(" ");
        }
        return stringBuilder.toString();
    }

    @ReadFullProcessorNameAnnotation
    public String readFullProcessorName(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNext()) {
            stringBuilder.append(scanner.nextLine());
        }
        return stringBuilder.toString();
    }
}

