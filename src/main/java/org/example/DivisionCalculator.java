package org.example;

import static java.lang.String.valueOf;
import static org.example.FormatterUtils.maxLineLength;

public class DivisionCalculator {

    public DivisionResultDTO calculateLines(int dividend, int divisor, int result) {
        int[] dividendArray = ints(dividend);
        int[] resultArray = ints(result);
        int countGetDownNumbers;
        int divisorSetCount = -1;
        String multiplied;
        StringBuilder residue = new StringBuilder();

        DivisionResultDTO dto = new DivisionResultDTO();

        dto.getFirstLineInt().add(dividend + "");
        dto.getFirstLineInt().add(divisor + "");
        dto.getSecondLineInt().add(0, "");
        dto.getThirdLineInt().add(result + "");
        dto.getLeftSpaces().add("");
        dto.getLeftSpaces().add("");

        for (int i = 0; i < dividendArray.length; i++) {
            divisorSetCount++;
            if (divisorSetCount < resultArray.length) {
                multiplied = valueOf(divisor * resultArray[divisorSetCount]);
                if (i == 0) {
                    residue.append(dividendArray[0]);
                    for (int u = 1; u < dividendArray.length; u++) {
                        if (Integer.parseInt(residue.toString()) < Integer.parseInt(multiplied)) {
                            residue.append(dividendArray[u]);
                        }
                    }
                    i = residue.length() - 1;
                }
                trim(residue);
                residue.append(Integer.parseInt(residue.toString()) - Integer.parseInt(multiplied));
                residue.delete(0, multiplied.length());
                if (i <= dividendArray.length - 2) {
                    residue.append(dividendArray[i + 1]);
                }
                trim(residue);
                countGetDownNumbers =
                    dividendArray.length -
                        residue.toString().length() -
                        (dividendArray.length - i - 1);

                dto.getFirstLineInt().add(residue.toString());
                dto.getSecondLineInt().add(multiplied);
                dto.getLeftSpaces().add(FormatterUtils.space(countGetDownNumbers, ' '));

            } else if (i == resultArray.length) {
                residue.append("0");
            }
        }
        if (dto.getFirstLineInt().get(dto.getFirstLineInt().size() - 1).equals(" ")) {
            dto.getFirstLineInt().add(dto.getFirstLineInt().size() - 1, "0");
            dto.getFirstLineInt().remove(dto.getFirstLineInt().size() - 1);
        }
        return dto;
    }

    private int[] ints(int base) {
        char[] chars = valueOf(base).toCharArray();
        int[] numbers = new int[maxLineLength(0, 0, base)];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(valueOf(chars[i]));
        }
        return numbers;
    }

    public void trim(StringBuilder toTrim) {
        int trimInt = Integer.parseInt(toTrim.toString().trim());
        toTrim.delete(0, toTrim.length());
        toTrim.append(trimInt);
    }
}