package org.example;

import java.util.ArrayList;

import static java.lang.String.valueOf;

public class DivisionFormatter {
    DivisionCalculator d = new DivisionCalculator();
    Formatter f = new Formatter();

    public ArrayList<String> firstLine = new ArrayList<>();
    public ArrayList<String> secondLine = new ArrayList<>();
    public ArrayList<String> thirdLine = new ArrayList<>();

    public String DivisionFormat(int a, int b, int result) {
        d.CalculatedLines(a, b, result);
        StringBuilder answer = new StringBuilder();
        StringBuilder leftSpaceFirstLine = new StringBuilder();
        StringBuilder leftSpaceSecondLine = new StringBuilder();
        String lastLeftSpace;
        int maxLeftLength = f.MaxLineLength(a, 0, 0) + 1;
        int maxRightLength = f.MaxLineLength(0, b, result);

        firstLine.add("_" + a + "|" + b);
        secondLine.add(" " + d.secondLineNumbers.get(1) + f.Space(maxLeftLength - d.secondLineNumbers.get(1).length() - 2, ' ') + "|" + f.Space(maxRightLength - 1, '-'));
        thirdLine.add(" " + f.Space(d.secondLineNumbers.get(1).length() - 1, '-') + f.Space(maxLeftLength - 2 - d.secondLineNumbers.get(1).length(), ' ') + "|" + d.thirdLineNumbers.get(0));

        for (int i = 2; i < d.secondLineNumbers.size(); i++) {
            leftSpaceFirstLine.append(d.countLeftSpaces.get(i));
            if (d.firstLineNumbers.get(i).length() == d.secondLineNumbers.get(i).length()) {
                leftSpaceSecondLine.append(leftSpaceFirstLine + " ");
            } else {
                leftSpaceSecondLine.append(leftSpaceFirstLine + "  ");
            }
            firstLine.add(leftSpaceFirstLine + "_" + d.firstLineNumbers.get(i));
            secondLine.add(leftSpaceSecondLine + d.secondLineNumbers.get(i));
            thirdLine.add(leftSpaceSecondLine + f.Space(d.secondLineNumbers.get(i).length() - 1, '-'));

            leftSpaceFirstLine.delete(0, leftSpaceFirstLine.length());
            leftSpaceSecondLine.delete(0, leftSpaceSecondLine.length());
        }
        lastLeftSpace = f.Space(maxLeftLength - valueOf(d.firstLineNumbers.get(d.firstLineNumbers.size() - 1)).length() - 1, ' ');
        firstLine.add(lastLeftSpace + d.firstLineNumbers.get(d.firstLineNumbers.size() - 1));

        for (int i = 0; i < secondLine.size(); i++) {
            answer.append(firstLine.get(i) + "\n");
            answer.append(secondLine.get(i) + "\n");
            answer.append(thirdLine.get(i) + "\n");
        }
        answer.append(firstLine.get(firstLine.size() - 1) + "\n");
        d.CleanCache();
        return answer.toString();
    }

    public void CleanCache() {
        firstLine.clear();
        secondLine.clear();
        thirdLine.clear();
    }
}