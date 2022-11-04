package org.example;

import java.util.ArrayList;

import static java.lang.String.valueOf;
import static org.example.FormatterUtils.maxLineLength;

public class DivisionCalculator {
    Formatter formatter = new Formatter();

    public ArrayList<String> firstLineInt = new ArrayList<>();
    public ArrayList<String> secondLineInt = new ArrayList<>();
    public ArrayList<String> thirdLineInt = new ArrayList<>();
    public ArrayList<String> leftSpaces = new ArrayList<>();

    public void calculatedLines(int dividend, int divisor, int result) {
        int[] dividendArray = ints(dividend);
        int[] resultArray = ints(result);
        int countGetDownNumbers;
        int divisorSetCount = -1;
        String multiplied;
        StringBuilder residue = new StringBuilder();

        firstLineInt.add(dividend + "");
        firstLineInt.add(divisor + "");
        secondLineInt.add(0, "");
        thirdLineInt.add(result + "");
        leftSpaces.add("");
        leftSpaces.add("");

        for (int i = 0; i < dividendArray.length; i++) {
            divisorSetCount++;
            if (divisorSetCount < resultArray.length) {
                multiplied = valueOf(divisor * resultArray[divisorSetCount]);
                if (i == 0) {
                    getDividendValue(residue, dividendArray, Integer.parseInt(multiplied));
                    i = residue.length() - 1;
                }
                trim(residue);
                residue.append(Integer.parseInt(residue.toString()) - Integer.parseInt(multiplied));
                residue.delete(0, multiplied.length());
                if (i <= dividendArray.length - 2) {
                    residue.append(dividendArray[i + 1]);
                }
                trim(residue);
                countGetDownNumbers = dividendArray.length - residue.toString().length() - (dividendArray.length - i - 1);

                firstLineInt.add(residue.toString());
                secondLineInt.add(multiplied);
                leftSpaces.add(formatter.space(countGetDownNumbers, ' '));

            } else if (i == resultArray.length) {
                residue.append("0");
            }
        }
        if (firstLineInt.get(firstLineInt.size() - 1).equals(" ")) {
            firstLineInt.add(firstLineInt.size() - 1, "0");
            firstLineInt.remove(firstLineInt.size() - 1);
        }
    }
    /**
     * Получаем первое значение residue (из первой строки, индекс 0)
     *
     * @param string        StringBuilder, в который мы будем вкладывать значение
     * @param dividendArray откуда берем значение
     * @param toCompare     для сравнения значения - если меньшеБ то спускаем еще одно число
     * @return итоговый
     */
    private StringBuilder getDividendValue(StringBuilder string, int[] dividendArray, int toCompare) {
        string.append(dividendArray[0]);
        for (int i = 1; i < dividendArray.length; i++) {
            if (Integer.parseInt(string.toString()) < toCompare) {
                string.append(dividendArray[i]);
            }
        }
        return string;
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
        int trimInt = Integer.parseInt(valueOf(toTrim.toString().trim()));
        toTrim.delete(0, toTrim.length());
        toTrim.append(trimInt);
    }
    public void cleanCache() {
        firstLineInt.clear();
        secondLineInt.clear();
        thirdLineInt.clear();
        leftSpaces.clear();
    }
}