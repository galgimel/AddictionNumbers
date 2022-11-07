package org.example;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;
import static org.example.FormatterUtils.maxLineLength;

public class DivisionFormatter {
    DivisionCalculator d = new DivisionCalculator();
    Formatter f = new Formatter();

    public String divisionFormat(int a, int b, int result) {

        List<String> firstLine = new ArrayList<>();
        List<String> secondLine = new ArrayList<>();
        List<String> thirdLine = new ArrayList<>();

        d.calculatedLines(a, b, result);
        StringBuilder answer = new StringBuilder();
        StringBuilder leftSpaceFirst = new StringBuilder();
        StringBuilder leftSpaceSecond = new StringBuilder();
        String lastLeftSpace;
        int leftSpace = maxLineLength(a, 0, 0) + 1;
        int rightSpace = maxLineLength(0, b, result);

        String space2 = f.space(leftSpace - d.secondLineInt.get(1).length() - 2, ' ');
        String space301 = f.space(d.secondLineInt.get(1).length() - 1, '-');
        String space302 = f.space(leftSpace - 2 - d.secondLineInt.get(1).length(), ' ');

        firstLine.add("_" + a + "|" + b);
        secondLine.add(" " + d.secondLineInt.get(1) + space2 + "|" + f.space(rightSpace - 1, '-'));
        thirdLine.add(" " + space301 + space302 + "|" + d.thirdLineInt.get(0));

        for (int i = 2; i < d.secondLineInt.size(); i++) {
            leftSpaceFirst.append(d.leftSpaces.get(i));
            if (d.firstLineInt.get(i).length() == d.secondLineInt.get(i).length()) {
                leftSpaceSecond.append(leftSpaceFirst + " ");
            } else {
                leftSpaceSecond.append(leftSpaceFirst + "  ");
            }
            firstLine.add(leftSpaceFirst + "_" + d.firstLineInt.get(i));
            secondLine.add(leftSpaceSecond + d.secondLineInt.get(i));
            thirdLine.add(leftSpaceSecond + f.space(d.secondLineInt.get(i).length() - 1, '-'));

            leftSpaceFirst.delete(0, leftSpaceFirst.length());
            leftSpaceSecond.delete(0, leftSpaceSecond.length());
        }
        lastLeftSpace = f.space(leftSpace - valueOf(d.firstLineInt.get(d.firstLineInt.size() - 1)).length() - 1, ' ');
        firstLine.add(lastLeftSpace + d.firstLineInt.get(d.firstLineInt.size() - 1));

        for (int i = 0; i < secondLine.size(); i++) {
            answer.append(firstLine.get(i) + "\n");
            answer.append(secondLine.get(i) + "\n");
            answer.append(thirdLine.get(i) + "\n");
        }
        answer.append(firstLine.get(firstLine.size() - 1) + "\n");
        d.cleanCache();
        return answer.toString();
    }
}