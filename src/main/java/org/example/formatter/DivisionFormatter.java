package org.example.formatter;

import org.example.DivisionCalculator;
import org.example.DivisionResultDTO;
import org.example.FormatterUtils;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;
import static org.example.Constants.*;
import static org.example.FormatterUtils.maxLineLength;

public class DivisionFormatter implements Formatter {
    private DivisionCalculator calculator;

    public DivisionFormatter(DivisionCalculator calculator) {
        this.calculator = calculator;
    }

    public String format(int a, int b, int result) {

        List<String> firstLine = new ArrayList<>();
        List<String> secondLine = new ArrayList<>();
        List<String> thirdLine = new ArrayList<>();

        calculator.calculateLines(a, b, result);
        StringBuilder answer = new StringBuilder();
        StringBuilder leftSpaceFirst = new StringBuilder();
        StringBuilder leftSpaceSecond = new StringBuilder();
        String lastLeftSpace;
        int leftSpace = maxLineLength(a, 0, 0) + 1;
        int rightSpace = maxLineLength(0, b, result);

        DivisionResultDTO dto = calculator.calculateLines(a, b, result);

        String space2 = FormatterUtils.space(leftSpace - dto.getSecondLineInt().get(1).length() - 2, CHAR_SPACE_SPLIT);
        String space301 = FormatterUtils.space(dto.getSecondLineInt().get(1).length() - 1, CHAR_MINUS);
        String space302 = FormatterUtils.space(leftSpace - 2 - dto.getSecondLineInt().get(1).length(), CHAR_SPACE_SPLIT);

        firstLine.add(FORMATTER_MINUS + a + SPLIT + b);
        secondLine.add(
            SPACE_SPLIT +
                dto.getSecondLineInt().get(1) +
                space2 +
                SPLIT +
                FormatterUtils.space(rightSpace - 1, CHAR_MINUS)
        );
        thirdLine.add(SPACE_SPLIT + space301 + space302 + SPLIT + dto.getThirdLineInt().get(0));

        for (int i = 2; i < dto.getSecondLineInt().size(); i++) {
            leftSpaceFirst.append(dto.getLeftSpaces().get(i));
            if (dto.getFirstLineInt().get(i).length() == dto.getSecondLineInt().get(i).length()) {
                leftSpaceSecond.append(leftSpaceFirst + SPACE_SPLIT);
            } else {
                leftSpaceSecond.append(leftSpaceFirst + SPACE_SPLIT + SPACE_SPLIT);
            }
            firstLine.add(leftSpaceFirst + FORMATTER_MINUS + dto.getFirstLineInt().get(i));
            secondLine.add(leftSpaceSecond + dto.getSecondLineInt().get(i));
            thirdLine.add(
                leftSpaceSecond + FormatterUtils.space(dto.getSecondLineInt().get(i).length() - 1, CHAR_MINUS)
            );

            leftSpaceFirst.delete(0, leftSpaceFirst.length());
            leftSpaceSecond.delete(0, leftSpaceSecond.length());
        }
        lastLeftSpace = FormatterUtils.space(
            leftSpace -
                valueOf(dto.getFirstLineInt().get(dto.getFirstLineInt().size() - 1)).length() - 1,
            CHAR_SPACE_SPLIT
        );
        firstLine.add(lastLeftSpace + dto.getFirstLineInt().get(dto.getFirstLineInt().size() - 1));

        for (int i = 0; i < secondLine.size(); i++) {
            answer.append(firstLine.get(i) + "\n");
            answer.append(secondLine.get(i) + "\n");
            answer.append(thirdLine.get(i) + "\n");
        }
        answer.append(firstLine.get(firstLine.size() - 1) + "\n");
        return answer.toString();
    }
}