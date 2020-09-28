import cn.edu.scu.utils.MatchUtil;
import org.apache.maven.artifact.versioning.ComparableVersion;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMavenVersion {


    class mavenVersionComparator implements Comparator {
        public int compare(Object o1, Object o2) {
            ComparableVersion v1 = new ComparableVersion(String.valueOf(o1));
            ComparableVersion v2 = new ComparableVersion(String.valueOf(o2));
            return v1.compareTo(v2);
        }
    }

    @Test
    public void test1() {
        String version1 = "2.0.0";
        String version2 = "2.8.9";
        String version3 = "11.0.3";
        String version4 = "11.0.3-sec";

        List<String> versions = new ArrayList<>();
        versions.add(version3);
        versions.add(version1);
        versions.add(version4);
        versions.add(version2);
        versions.sort(new mavenVersionComparator());
        versions.forEach(System.out::println);
    }

    @Test
    public void test2() {
        String version_range1 = "(,1.0],[1.2,)";
        String version_range2 = "(,1.1),(1.1,)";
        String version_range3 = "(1.0,2.0)";
        String version_range4 = "(,2.0)";
        String version_range6 = "[0.3m]";


//        Pattern pattern = Pattern.compile("(?<=\\]|\\)),(?=\\[|\\()");
//        Matcher matcher = pattern.matcher(version_range2);
//
//        while (matcher.find()) {
//            System.out.println(matcher.group());
//        }

        String version_range5 = "(,1.0],[1.2,),[2.3,]";
        String[] versions = version_range5.split("(?<=\\]|\\)),(?=\\[|\\()");
        Arrays.stream(versions).forEach(System.out::println);
        String max_version;
        for (String version : versions) {

        }
    }

    @Test
    public void test3() {
        String content = "project.ext {\n" +
                "11     aspectJversion = 1.8.+\n" +
                "12    otherVersion = '1.8.+'\n" +
                "         }";

        Pattern pattern = Pattern.compile("(\\d+)\\s*(\\S+)\\s*=\\s*[\"\']?([\\d\\.\\+]+)(?=[\'\"]?)");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));

        }
    }

    @Test
    public void test4() {
        String content = "// final marking of TextWord corresponding to line numbers\n" +
                "    for (int i = 0; i < bestCluster.size(); i++) {\n" +
                "        int index = bestCluster[i];\n" +
                "        word = lineNumberWords[index];\n" +
                "        // consider only aligned tokens\n" +
                "        word->setLineNumber(true);\n" +
                "    }\n" +
                "\n" +
                "    return hasLineNumber;\n" +
                "}\n" +
                "\n" +
                "void TextPage::dump(GBool noLineNumbers, GBool fullFontName, vector<bool> lineNumberStatus) {\n" +
                "    // Output the page in raw (content stream) order\n" +
                "    blocks = new GList(); //these are blocks in alto schema\n" +
                "\n" +
                "    UnicodeMap *uMap;\n" +
                "\n" +
                "    TextFontStyleInfo *fontStyleInfo;\n" +
                "\n" +
                "    GString *id;\n" +
                "\n" +
                "    // For TEXT tag attributes\n" +
                "    double xMin = 0;\n" +
                "    double yMin = 0;\n" +
                "    double xMax = 0;\n" +
                "    double yMax = 0;\n" +
                "    double yMaxRot = 0;\n" +
                "    double yMinRot = 0;\n" +
                "    double xMaxRot = 0;\n" +
                "    double xMinRot = 0;\n" +
                "    int firstword = 1; // firstword of a TEXT tag\n" +
                "\n" +
                "    // x and y for nodeline: min (xi) min(yi) whatever the text rotation is\n" +
                "    double minLineX = 0;\n" +
                "    double minLineY = 0;\n" +
                "\n" +
                "    GBool lineFinish = gFalse;\n" +
                "    GBool newBlock = gFalse;\n" +
                "    GBool endPage = gFalse;\n" +
                "    GBool lastBlockInserted = gFalse; // true if the last added block is inserted before an existing node, false is appended\n" +
                "\n" +
                "    // Informations about the current line\n" +
                "    double lineX = 0;\n" +
                "    double lineYmin = 0;\n" +
                "    double lineWidth = 0;\n" +
                "    double lineHeight = 0;\n" +
                "    double lineFontSize = 0;\n" +
                "\n" +
                "    // Informations about the previous line\n" +
                "    double linePreviousX = 0;\n" +
                "    double linePreviousYmin = 0;\n" +
                "    double linePreviousWidth = 0;\n" +
                "    double linePreviousHeight = 0;\n" +
                "    double linePreviousFontSize = 0;\n" +
                "\n" +
                "    double minBlockX = 0;\n" +
                "    double maxBlockLineWidth = 0;\n" +
                "\n" +
                "    // Get the output encoding\n" +
                "    if (!(uMap = globalParams->getTextEncoding())) {\n" +
                "        return;\n" +
                "    }\n" +
                "\n" +
                "    numText = 1;\n" +
                "    numBlock = 1;\n" +
                "\n" +
                "    lineFontSize = 0;\n" +
                "\n" +
                "    TextLine *line = new TextLine;\n" +
                "\n" +
                "    GList *lineWords = new GList();\n" +
                "    line->setWords(lineWords);\n" +
                "\n" +
                "    GList *parLines = new GList();\n" +
                "\n" +
                "    TextParagraph *paragraph = new TextParagraph;\n" +
                "    paragraph->setLines(parLines);\n" +
                "\n" +
                "    minBlockX = 999999;\n" +
                "    maxBlockLineWidth = 0;\n" +
                "\n" +
                "    xMin = yMin = xMax = yMax = 0;\n" +
                "    minLineX = 999999;\n" +
                "    minLineY = 999999;\n" +
                "\n" +
                "    int wordId = 0;\n" +
                "    for (wordId = 0; wordId < words->getLength(); wordId++) {\n" +
                "\n" +
                "        TextRawWord *word, *nextWord, *prvWord;\n" +
                "        word = (TextRawWord *) words->get(wordId);\n" +
                "        if (wordId + 1 < words->getLength())\n" +
                "            nextWord = (TextRawWord *) words->get(wordId + 1);\n" +
                "        else nextWord = NULL;\n" +
                "        if (wordId != 0)\n" +
                "            prvWord = (TextRawWord *) words->get(wordId - 1);\n" +
                "\n" +
                "        char *tmp;\n" +
                "\n" +
                "        tmp = (char *) malloc(10 * sizeof(char));\n" +
                "        fontStyleInfo = new TextFontStyleInfo;\n" +
                "\n" +
                "        lineFinish = gFalse;\n" +
                "        if (firstword) { // test useful?\n" +
                "            xMin = word->xMin;\n" +
                "            yMin = word->yMin;\n" +
                "            xMax = word->xMax;\n" +
                "            yMax = word->yMax;\n" +
                "            yMaxRot = word->yMax;\n" +
                "            yMinRot = word->yMin;\n" +
                "            xMaxRot = word->xMax;\n" +
                "            xMinRot = word->xMin;\n" +
                "            lineX = word->xMin;\n" +
                "            lineYmin = word->yMin;\n" +
                "            firstword = 0;\n" +
                "            lineFontSize = 0;\n" +
                "        }\n" +
                "        if (word->xMin < minLineX) {\n" +
                "            minLineX = word->xMin;\n" +
                "        } // for nodeline\n" +
                "        if (word->yMin < minLineY) {\n" +
                "            minLineY = word->yMin;\n" +
                "        } // for nodeline\n" +
                "\n" +
                "        if (word->fontSize > lineFontSize) {\n" +
                "            lineFontSize = word->fontSize;\n" +
                "        }\n" +
                "\n" +
                "        if (word->xMax > xMax) {\n" +
                "            xMax = word->xMax;\n" +
                "        }\n" +
                "        if (word->xMin < xMinRot) {\n" +
                "            xMinRot = word->xMin;\n" +
                "        }\n" +
                "        if (word->xMax > xMaxRot) {\n" +
                "            xMaxRot = word->xMax;\n" +
                "        }\n" +
                "        if (word->yMax > yMax) {\n" +
                "            yMax = word->yMax;\n" +
                "        }\n" +
                "        if (word->yMin < yMinRot) {\n" +
                "            yMinRot = word->yMin;\n" +
                "        }\n" +
                "        if (word->yMax > yMaxRot) {\n" +
                "            yMaxRot = word->yMax;\n" +
                "        }\n" +
                "\n" +
                "        // If option verbose is selected\n" +
                "        /// annotations: higlighted, underline,\n" +
                "\n" +
                "        double xxMin, xxMax, xxMinNext;\n" +
                "        double yyMin, yyMax, yyMinNext;\n" +
                "\n" +
                "        // Rotation cases\n" +
                "        switch (word->rot) {\n" +
                "            case 0:\n" +
                "                xxMin = word->xMin;\n" +
                "                xxMax = word->xMax;\n" +
                "                yyMin = word->yMin;\n" +
                "                yyMax = word->yMax;\n" +
                "                if (nextWord) {\n" +
                "                    xxMinNext = nextWord->xMin;\n" +
                "                    yyMinNext = nextWord->yMin;\n" +
                "                }\n" +
                "                break;\n" +
                "\n" +
                "            case 3:\n" +
                "                xxMin = word->yMin;\n" +
                "                xxMax = word->yMax;\n" +
                "                yyMin = word->xMax;\n" +
                "                yyMax = word->xMin;\n" +
                "                if (nextWord) {\n" +
                "                    xxMinNext = nextWord->yMin;\n" +
                "                    yyMinNext = nextWord->xMax;\n" +
                "                }\n" +
                "                break;\n" +
                "\n" +
                "            case 2:\n" +
                "                xxMin = word->xMax;\n" +
                "                xxMax = word->xMin;\n" +
                "                yyMin = word->yMax;\n" +
                "                yyMax = word->yMin;\n" +
                "                if (nextWord) {\n" +
                "                    xxMinNext = nextWord->xMax;\n" +
                "                    yyMinNext = nextWord->yMax;\n" +
                "                }\n" +
                "                break;\n" +
                "\n" +
                "            case 1:\n" +
                "                xxMin = word->yMax;\n" +
                "                xxMax = word->yMin;\n" +
                "                yyMin = word->xMax;\n" +
                "                yyMax = word->xMin;\n" +
                "                if (nextWord) {\n" +
                "                    xxMinNext = nextWord->yMax;\n" +
                "                    yyMinNext = nextWord->xMax;\n" +
                "                }\n" +
                "                break;\n" +
                "        }\n" +
                "\n" +
                "        // Get the rotation into four axis\n" +
                "        int rotation = -1;\n" +
                "        if (word->rot == 0 && word->angle == 0) {\n" +
                "            rotation = 0;\n" +
                "        }\n" +
                "        if (word->rot == 1 && word->angle == 90) {\n" +
                "            rotation = 1;\n" +
                "        }\n" +
                "        if (word->rot == 2 && word->angle == 180) {\n" +
                "            rotation = 2;\n" +
                "        }\n" +
                "        if (word->rot == 3 && word->angle == 270) {\n" +
                "            rotation = 3;\n" +
                "        }\n" +
                "\n" +
                "        // The line is finished IF :\n" +
                "        // \t\t- there is no next word\n" +
                "        //\t\t- and IF the rotation of current word is different of the rotation next word\n" +
                "        //\t\t- and IF the difference between the base of current word and the yMin next word is superior to the maxSpacingWordsBetweenTwoLines\n" +
                "        //\t\t-      or IF the difference between the base of current word and the base next word is superior to maxIntraLineDelta * lineFontSize\n" +
                "        //\t\t- and IF the xMax current word ++ maxWordSpacing * lineFontSize is superior to the xMin next word.\n" +
                "        //\t\tHD 24/07/09 ?? - or if the font size of the current word is far different from the next word\n" +
                "        // PL: note that the second criteria create an artificial new line for every superscript sequences whithin a line (but subscript are okay), we\n" +
                "        // revised it by taking the max of lineFontSize and nextWord fontSize, instead of the min (it means we have a new line when the shift if greater\n" +
                "        // than the main font size, a smaller shift does not introduce a new line)\n" +
                "        if (nextWord != NULL && (word->rot == nextWord->rot) && (\n" +
                "                (\n" +
                "                    (fabs(word->base - nextWord->baseYmin) < maxSpacingWordsBetweenTwoLines) ||\n" +
                "                    //(fabs(nextWord->base - word->base) < maxIntraLineDelta * min(lineFontSize, nextWord->fontSize))\n" +
                "                    //(fabs(nextWord->base - word->base) < maxIntraLineDelta * lineFontSize)\n" +
                "                    (fabs(nextWord->base - word->base) < maxIntraLineDelta * max(lineFontSize, nextWord->fontSize))\n" +
                "                )\n" +
                "                && (nextWord->xMin <= word->xMax + maxWordSpacing * lineFontSize)\n" +
                "            )\n" +
                "        ) {\n" +
                "\n" +
                "            // IF - switch the rotation :\n" +
                "            //\t\t\tbase word and yMin word are inferior to yMin next word\n" +
                "            //\t\t\txMin word is superior to xMin next word\n" +
                "            //\t\t\txMax word is superior to xMin next word and the difference between the base of current word and the next word is superior to maxIntraLineDelta*lineFontSize\n" +
                "            //\t\t\txMin next word is superior to xMax word + maxWordSpacing * lineFontSize\n" +
                "            //THEN if one of these tests is true, the line is finish\n" +
                "            if (\n" +
                "                ((rotation == -1) ? ((word->base < nextWord->yMin)\n" +
                "                                     && (word->yMin < nextWord->yMin)) : (word->rot == 0\n" +
                "                                                                          || word->rot == 1) ? (\n" +
                "                                                                                 (word->base < yyMinNext) && (yyMin\n" +
                "                                                                                                              <\n" +
                "                                                                                                              yyMinNext))\n" +
                "                                                                                             : (\n" +
                "                                                                                 (word->base > yyMinNext) && (yyMin\n" +
                "                                                                                                              >\n" +
                "                                                                                                              yyMinNext)))\n" +
                "                || ((rotation == -1) ? (nextWord->xMin\n" +
                "                                     < word->xMin) : (word->rot == 0) ? (xxMinNext < xxMin)\n" +
                "                                                                      : (word->rot == 1 ? xxMinNext > xxMin\n" +
                "                                                                                        : (word->rot == 2 ? xxMinNext >\n" +
                "                                                                                                            xxMin :\n" +
                "                                                                                           xxMinNext\n" +
                "                                                                                           < xxMin)))\n" +
                "                || ((rotation == -1) ? (nextWord->xMin < word->xMax)\n" +
                "                                       && (fabs(nextWord->base - word->base)\n" +
                "                                           > maxIntraLineDelta * lineFontSize)\n" +
                "                                     : (word->rot == 0 || word->rot == 3) ? ((xxMinNext < xxMax)\n" +
                "                                                                             && (fabs(nextWord->base - word->base)\n" +
                "                                                                                 > maxIntraLineDelta * lineFontSize))\n" +
                "                                                                          : ((xxMinNext > xxMax)\n" +
                "                                                                             && (fabs(nextWord->base\n" +
                "                                                                                      - word->base)\n" +
                "                                                                                 > maxIntraLineDelta * lineFontSize)))\n" +
                "                || ((rotation == -1) ? (nextWord->xMin > word->xMax\n" +
                "                                                         + maxWordSpacing * lineFontSize) : (word->rot == 0\n" +
                "                                                                                             || word->rot == 3) ? (\n" +
                "                                                                                                    xxMinNext > xxMax\n" +
                "                                                                                                                +\n" +
                "                                                                                                                maxWordSpacing *\n" +
                "                                                                                                                lineFontSize)\n" +
                "                                                                                                                : (\n" +
                "                                                                                                    xxMinNext\n" +
                "                                                                                                    < xxMax -\n" +
                "                                                                                                      maxWordSpacing *\n" +
                "                                                                                                      lineFontSize))\n" +
                "            ) {\n" +
                "                lineWords->append(word); // here we first add this last word to line then create new line\n" +
                "                if (word->rot == 2) {\n" +
                "                    lineWidth = fabs(xMaxRot - xMinRot);\n" +
                "                } else {\n" +
                "                    lineWidth = xMax - xMin;\n" +
                "                }\n" +
                "\n" +
                "                if (word->rot == 0 || word->rot == 2) {\n" +
                "                    lineHeight = yMax - yMin;\n" +
                "                }\n" +
                "\n" +
                "                if (word->rot == 1 || word->rot == 3) {\n" +
                "                    lineHeight = yMaxRot - yMinRot;\n" +
                "                }\n" +
                "                if (word->fontSize > lineFontSize) {\n" +
                "                    lineFontSize = word->fontSize;\n" +
                "                }\n" +
                "                line->setXMin(minLineX);\n" +
                "                line->setXMax(minLineX + lineWidth);\n" +
                "                line->setYMax(minLineY + lineHeight);\n" +
                "                line->setYMin(minLineY);\n" +
                "                line->setFontSize(lineFontSize);\n" +
                "\n" +
                "                if (nextWord != NULL) {\n" +
                "                    firstword = 1;\n" +
                "                    // PL: blocks are now always considered at this stage\n" +
                "                    lineFinish = gTrue;\n" +
                "                } else {\n" +
                "                    endPage = gTrue;\n" +
                "                }\n" +
                "                xMin = yMin = xMax = yMax = yMinRot = yMaxRot = xMaxRot\n" +
                "                        = xMinRot = 0;\n" +
                "            } else {\n" +
                "                lineWords->append(word);\n" +
                "            }\n" +
                "        } else {\n" +
                "            // node to be added to nodeline\n" +
                "            if (word->rot == 2) {\n" +
                "                lineWidth = fabs(xMaxRot - xMinRot);\n" +
                "            } else {\n" +
                "                lineWidth = xMax - xMin;\n" +
                "            }\n" +
                "\n" +
                "            if (word->rot == 0 || word->rot == 2) {\n" +
                "                lineHeight = yMax - yMin;\n" +
                "            }\n" +
                "\n" +
                "            if (word->rot == 1 || word->rot == 3) {\n" +
                "                lineHeight = yMaxRot - yMinRot;\n" +
                "            }\n" +
                "\n" +
                "            lineWords->append(word);\n" +
                "\n" +
                "            if (word->fontSize > lineFontSize) {\n" +
                "                lineFontSize = word->fontSize;\n" +
                "            }\n" +
                "\n" +
                "            line->setXMin(minLineX);\n" +
                "            line->setXMax(minLineX + lineWidth);\n" +
                "            line->setYMax(minLineY + lineHeight);\n" +
                "            line->setYMin(minLineY);\n" +
                "            line->setFontSize(lineFontSize);\n" +
                "\n" +
                "            if (nextWord != NULL) {\n" +
                "                // PL: blocks are now always considered at this stage\n" +
                "                lineFinish = gTrue;\n" +
                "            } else {\n" +
                "                endPage = gTrue;\n" +
                "            }\n" +
                "\n" +
                "            firstword = 1;\n" +
                "            xMin = yMin = xMax = yMax = yMinRot = yMaxRot = xMaxRot = xMinRot\n" +
                "                    = 0;\n" +
                "            minLineY = 999999;\n" +
                "            minLineX = 999999;\n" +
                "        }\n" +
                "\n" +
                "        // IF it's the end of line or the end of page\n" +
                "        if ((lineFinish) || (endPage)) {\n" +
                "            // IF it's the first line\n" +
                "            if (linePreviousX == 0) {\n" +
                "                if (nextWord != NULL) {\n" +
                "                    if (nextWord->xMin > (lineX + lineWidth)\n" +
                "                                         + (maxColSpacing * lineFontSize)) {\n" +
                "                        newBlock = gTrue;\n" +
                "                    }\n" +
                "                }\n" +
                "\n" +
                "                // PL: check if X and Y coordinates of the current block are present\n" +
                "                // and set them if it's not the case\n" +
                "                if (paragraph != NULL) {\n" +
                "                    // get block X and Y\n" +
                "                    if (paragraph->getXMin() == 0) {\n" +
                "                        if (lineX != 0  && minBlockX > lineX) {\n" +
                "                            minBlockX = lineX;\n" +
                "                            paragraph->setXMin(lineX);\n" +
                "                        }\n" +
                "                    }\n" +
                "                    if (paragraph->getYMin() == 0) {\n" +
                "                        if (lineYmin != 0)\n" +
                "                            paragraph->setYMin(lineYmin);\n" +
                "                    }\n" +
                "                }\n" +
                "                if(maxBlockLineWidth < lineWidth)\n" +
                "                    maxBlockLineWidth = lineWidth;\n" +
                "                parLines->append(line);\n" +
                "            } else {\n" +
                "                if (newBlock) {\n" +
                "                    // PL: previous block height and width\n" +
                "                    if (paragraph != NULL) {\n" +
                "                        // get block X and Y\n" +
                "                        double blockX = 0;\n" +
                "                        double blockY = 0;\n" +
                "                        if (paragraph->getXMin() != 0) {\n" +
                "                            blockX = paragraph->getXMin();\n" +
                "                        }\n" +
                "                        if (paragraph->getYMin() != 0) {\n" +
                "                            blockY = paragraph->getYMin();\n" +
                "                        }\n" +
                "\n" +
                "                        //double blockWidth = std::abs((linePreviousX + linePreviousWidth) - blockX);\n" +
                "                        double blockHeight = std::abs((linePreviousYmin + linePreviousHeight) - blockY);\n" +
                "\n" +
                "                        paragraph->setYMax(paragraph->getYMin() + blockHeight);\n" +
                "                        paragraph->setXMax(paragraph->getXMin() + maxBlockLineWidth);\n" +
                "\n" +
                "                        // adding previous block to the page element\n" +
                "                        if(readingOrder && num == 1)\n" +
                "                            lastBlockInserted = addBlockInReadingOrder(paragraph, lineFontSize, lastBlockInserted);\n" +
                "                        else\n" +
                "                            blocks->append(paragraph);\n" +
                "                    }\n" +
                "\n" +
                "                    paragraph = new TextParagraph;\n" +
                "                    parLines = new GList();\n" +
                "                    paragraph->setLines(parLines);\n" +
                "\n" +
                "                    minBlockX = 999999;\n" +
                "                    maxBlockLineWidth = 0;\n" +
                "\n" +
                "                    if (lineX != 0 && minBlockX > lineX) {\n" +
                "                        minBlockX = lineX;\n" +
                "                        paragraph->setXMin(lineX);\n" +
                "                    }\n" +
                "                    if (lineYmin != 0)\n" +
                "                        paragraph->setYMin(lineYmin);\n" +
                "\n" +
                "                    if(maxBlockLineWidth < lineWidth)\n" +
                "                        maxBlockLineWidth = lineWidth;\n" +
                "\n" +
                "                    parLines->append(line);\n" +
                "                    newBlock = gFalse;\n" +
                "                } else {\n" +
                "                    if (((lineYmin + lineHeight) >= linePreviousYmin)\n" +
                "                        && (fabs(lineFontSize - linePreviousFontSize)\n" +
                "                            < lineFontSize * maxBlockFontSizeDelta1)\n" +
                "                        && ((lineYmin - linePreviousYmin)\n" +
                "                            < (linePreviousFontSize\n" +
                "                               * maxLineSpacingDelta))) {\n" +
                "                        if (endPage) {\n" +
                "                            // PL: check if the width and the height of the current block are present\n" +
                "                            // and set them if it's not the case\n" +
                "                            if (paragraph != NULL) {\n" +
                "                                if (paragraph->getYMax() == 0) {\n" +
                "                                    double blockY = paragraph->getYMin();\n" +
                "                                    double blockHeight = std::abs((linePreviousYmin + linePreviousHeight) - blockY);\n" +
                "                                    paragraph->setYMax(blockY + blockHeight);\n" +
                "                                }\n" +
                "                                if (paragraph->getXMax() == 0) {\n" +
                "                                    double blockX = paragraph->getXMin();\n" +
                "                                    //double blockWidth = std::abs((linePreviousX + linePreviousWidth) - blockX);\n" +
                "                                    paragraph->setXMax(blockX + maxBlockLineWidth);\n" +
                "                                }\n" +
                "                            }\n" +
                "                        }\n" +
                "\n" +
                "                        if (lineX != 0 && minBlockX > lineX) {\n" +
                "                            minBlockX = lineX;\n" +
                "                            paragraph->setXMin(lineX);\n" +
                "                        }\n" +
                "\n" +
                "                        if(maxBlockLineWidth < lineWidth)\n" +
                "                            maxBlockLineWidth = lineWidth;\n" +
                "\n" +
                "                        parLines->append(line);\n" +
                "                    } else {\n" +
                "                        // PL: previous block height and width\n" +
                "                        if (paragraph != NULL) {\n" +
                "                            // get block X and Y\n" +
                "\n" +
                "                            //double blockWidth = std::abs((linePreviousX + linePreviousWidth) - paragraph->getXMin());\n" +
                "                            double blockHeight = std::abs((linePreviousYmin + linePreviousHeight) - paragraph->getYMin());\n" +
                "\n" +
                "                            paragraph->setXMax(paragraph->getXMin() + maxBlockLineWidth);\n" +
                "                            paragraph->setYMax(paragraph->getYMin() + blockHeight);\n" +
                "\n" +
                "                            // adding previous block to the page element\n" +
                "                            if(readingOrder && num == 1)\n" +
                "                                lastBlockInserted = addBlockInReadingOrder(paragraph, lineFontSize, lastBlockInserted);\n" +
                "                            else\n" +
                "                                blocks->append(paragraph);\n" +
                "                        }\n" +
                "\n" +
                "                        paragraph = new TextParagraph;\n" +
                "                        parLines = new GList();\n" +
                "                        paragraph->setLines(parLines);\n" +
                "\n" +
                "                        minBlockX = 999999;\n" +
                "                        maxBlockLineWidth = 0;\n" +
                "\n" +
                "                        // PL: new block X and Y\n" +
                "                        if (lineX != 0 && minBlockX > lineX) {\n" +
                "                            minBlockX = lineX;\n" +
                "                            paragraph->setXMin(lineX);\n" +
                "                        }\n" +
                "                        if (lineYmin != 0) {\n" +
                "                            paragraph->setYMin(lineYmin);\n" +
                "                        }\n" +
                "\n" +
                "                        if(maxBlockLineWidth < lineWidth)\n" +
                "                            maxBlockLineWidth = lineWidth;\n" +
                "\n" +
                "                        parLines->append(line);\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "            if (endPage) {\n" +
                "                endPage = gFalse;\n" +
                "\n" +
                "                if (paragraph != NULL) {\n" +
                "                    if(readingOrder && num == 1)\n" +
                "                        lastBlockInserted = addBlockInReadingOrder(paragraph, lineFontSize, lastBlockInserted);\n" +
                "                    else\n" +
                "                        blocks->append(paragraph);\n" +
                "                    lastBlockInserted = gFalse;\n" +
                "                }\n" +
                "            }\n" +
                "\n" +
                "            if(minLineX < minBlockX)\n" +
                "                minBlockX = minLineX;\n" +
                "            if(lineWidth > maxBlockLineWidth)\n" +
                "                maxBlockLineWidth = lineWidth;\n" +
                "\n" +
                "            // We save informations about the future previous line\n" +
                "            linePreviousX = lineX;\n" +
                "            linePreviousYmin = lineYmin;\n" +
                "            linePreviousWidth = lineWidth;\n" +
                "            linePreviousHeight = lineHeight;\n" +
                "            linePreviousFontSize = lineFontSize;\n" +
                "            minLineY = 999999;\n" +
                "            minLineX = 999999;\n" +
                "            line = new TextLine;\n" +
                "            lineWords = new GList();\n" +
                "            line->setWords(lineWords);\n" +
                "        }\n" +
                "\n" +
                "        free(tmp);\n" +
                "    } // end FOR\n" +
                "\n" +
                "    // if no line number was found in the first half of the document and the number of pages of the document is large enough,\n" +
                "    // we do don't need to look for line numbers any more\n" +
                "    int nbTotalPage = myCat->getNumPages();\n" +
                "    int currentPageNumber = getPageNumber();\n" +
                "\n" +
                "    //cout << \"nbTotalPage: \" << nbTotalPage << endl;\n" +
                "    //cout << \"currentPageNumber: \" << currentPageNumber << endl;\n" +
                "\n" +
                "    // check if the previous pages have line numbers\n" +
                "    bool previousLineNumber = true;\n" +
                "    for(int i=0; i<lineNumberStatus.size(); i++) {\n" +
                "        previousLineNumber = lineNumberStatus[i];\n" +
                "        if (previousLineNumber)\n" +
                "            break;\n" +
                "    }\n" +
                "    \n" +
                "    bool hasLineNumber = false;\n" +
                "    if ( (currentPageNumber < nbTotalPage/2) || (previousLineNumber && nbTotalPage>4)) {\n" +
                "        hasLineNumber = markLineNumber();\n" +
                "        //cout << \"result markLineNumber: \" << hasLineNumber << endl;\n" +
                "    }\n" +
                "    setLineNumber(hasLineNumber);\n" +
                "\n" +
                "    xmlNodePtr node = NULL;\n" +
                "    xmlNodePtr nodeline = NULL;\n" +
                "    xmlNodePtr nodeblocks = NULL;\n" +
                "    xmlNodePtr nodeImageInline = NULL;\n" +
                "\n" +
                "    TextParagraph *par;\n" +
                "    TextLine *line1;\n" +
                "    TextWord *word;\n" +
                "    TextWord *nextWord;\n" +
                "\n" +
                "    int parIdx, lineIdx, wordI, n;\n" +
                "\n" +
                "    printSpace = xmlNewNode(NULL, (const xmlChar*)TAG_PRINTSPACE);\n" +
                "    printSpace->type = XML_ELEMENT_NODE;\n" +
                "    xmlAddChild(page, printSpace);\n" +
                "\n" +
                "    // for superscript/subscript determination\n" +
                "    double previousWordBaseLine = 0;\n" +
                "    double previousWordYmin = 0;\n" +
                "    double previousWordYmax = 0;\n" +
                "    double currentLineBaseLine = 0;\n" +
                "    double currentLineYmin = 0;\n" +
                "    double currentLineYmax = 0;\n" +
                "\n" +
                "    if (hasLineNumber && !noLineNumbers) {\n" +
                "        // we preliminary introduce a block for line numbers, if any and if we have to display them\n" +
                "\n" +
                "        // first grab the line numbers\n" +
                "        GList *lineNumberWords = new GList();\n" +
                "        for(parIdx = 0; parIdx < blocks->getLength(); parIdx++) {\n" +
                "            par = (TextParagraph *) blocks->get(parIdx);\n" +
                "\n" +
                "            for(lineIdx = 0; lineIdx < par->lines->getLength(); lineIdx++) {\n" +
                "                line1 = (TextLine *) par->lines->get(lineIdx);\n" +
                "\n" +
                "                for(wordI = 0; wordI < line1->words->getLength(); wordI++) {\n" +
                "                    word = (TextWord *) line1->words->get(wordI);\n" +
                "\n" +
                "                    if (word->lineNumber && (is_number(word))) {\n" +
                "                        lineNumberWords->append(word);\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        if (lineNumberWords->getLength() > 0) {\n" +
                "\n" +
                "            // compute the dim of the block\n" +
                "            double blockXMin = 999999;\n" +
                "            double blockXMax = 0;\n" +
                "            double blockYMin = 999999;\n" +
                "            double blockYMax = 0;\n" +
                "\n" +
                "            for(wordI = 0; wordI < lineNumberWords->getLength(); wordI++) {\n" +
                "                word = (TextWord *) lineNumberWords->get(wordI);\n" +
                "\n" +
                "                if (word->xMin < blockXMin)\n" +
                "                    blockXMin = word->xMin;\n" +
                "                if (word->yMin < blockYMin)\n" +
                "                    blockYMin = word->yMin;\n" +
                "\n" +
                "                if (word->xMax > blockXMax)\n" +
                "                    blockXMax = word->xMax;\n" +
                "                if (word->yMax > blockYMax)\n" +
                "                    blockYMax = word->yMax;\n" +
                "            }\n" +
                "\n" +
                "            // create custom block for line numbers\n" +
                "            nodeblocks = xmlNewNode(NULL, (const xmlChar *) TAG_BLOCK);\n" +
                "            nodeblocks->type = XML_ELEMENT_NODE;\n" +
                "\n" +
                "            id = new GString(\"p\");\n" +
                "            xmlNewProp(nodeblocks, (const xmlChar *) ATTR_ID,\n" +
                "                       (const xmlChar *) buildIdBlock(num, numBlock, id)->getCString());\n" +
                "            delete id;\n" +
                "            numBlock = numBlock + 1;\n" +
                "\n" +
                "            char *tmp;\n" +
                "            tmp = (char *) malloc(10 * sizeof(char));\n" +
                "            snprintf(tmp, sizeof(tmp),ATTR_NUMFORMAT, blockXMin);\n" +
                "            xmlNewProp(nodeblocks, (const xmlChar*)ATTR_X, (const xmlChar*)tmp);\n" +
                "            snprintf(tmp, sizeof(tmp),ATTR_NUMFORMAT, blockYMin);\n" +
                "            xmlNewProp(nodeblocks, (const xmlChar*)ATTR_Y, (const xmlChar*)tmp);\n" +
                "            snprintf(tmp, sizeof(tmp),ATTR_NUMFORMAT, blockYMax - blockYMin);\n" +
                "            xmlNewProp(nodeblocks, (const xmlChar*)ATTR_HEIGHT, (const xmlChar*)tmp);\n" +
                "            snprintf(tmp, sizeof(tmp),ATTR_NUMFORMAT, blockXMax - blockXMin);\n" +
                "            xmlNewProp(nodeblocks, (const xmlChar*)ATTR_WIDTH, (const xmlChar*)tmp);\n" +
                "            free(tmp);\n" +
                "\n" +
                "            for(wordI = 0; wordI < lineNumberWords->getLength(); wordI++) {\n" +
                "                word = (TextWord *) lineNumberWords->get(wordI);\n" +
                "                \n" +
                "                // create lines with one number\n" +
                "                nodeline = xmlNewNode(NULL, (const xmlChar *) TAG_TEXT);\n" +
                "                nodeline->type = XML_ELEMENT_NODE;\n" +
                "\n" +
                "                id = new GString(\"p\");\n" +
                "                xmlNewProp(nodeline, (const xmlChar*)ATTR_ID,\n" +
                "                           (const xmlChar*)buildIdText(num, numText, id)->getCString());\n" +
                "                delete id;\n" +
                "                numText = numText + 1;\n" +
                "\n" +
                "                char *tmp;\n" +
                "                tmp = (char *) malloc(10 * sizeof(char));\n" +
                "                snprintf(tmp, sizeof(tmp),ATTR_NUMFORMAT, word->xMax - word->xMin);\n" +
                "                xmlNewProp(nodeline, (const xmlChar*)ATTR_WIDTH, (const xmlChar*)tmp);\n" +
                "                snprintf(tmp, sizeof(tmp),ATTR_NUMFORMAT, word->yMax - word->yMin);\n" +
                "                xmlNewProp(nodeline, (const xmlChar*)ATTR_HEIGHT, (const xmlChar*)tmp);\n" +
                "                snprintf(tmp, sizeof(tmp),ATTR_NUMFORMAT, word->xMin);\n" +
                "                xmlNewProp(nodeline, (const xmlChar*)ATTR_X, (const xmlChar*)tmp);\n" +
                "                snprintf(tmp, sizeof(tmp),ATTR_NUMFORMAT, word->yMin);\n" +
                "                xmlNewProp(nodeline, (const xmlChar*)ATTR_Y, (const xmlChar*)tmp);\n" +
                "                free(tmp);\n" +
                "\n" +
                "                // create the number token\n" +
                "                node = xmlNewNode(NULL, (const xmlChar *) TAG_TOKEN);\n" +
                "                node->type = XML_ELEMENT_NODE;\n" +
                "\n" +
                "                fontStyleInfo = new TextFontStyleInfo;\n" +
                "\n" +
                "                tmp = (char *) malloc(10 * sizeof(char));\n" +
                "\n" +
                "                // if option verbose is selected\n" +
                "                if (verbose) {\n" +
                "                    addAttributsNodeVerbose(node, tmp, word);\n" +
                "                }\n" +
                "                addAttributsNode(node, word, fontStyleInfo, uMap, fullFontName);\n" +
                "                addAttributTypeReadingOrder(node, tmp, word);    \n" +
                "                free(tmp);\n" +
                "\n" +
                "                xmlAddChild(nodeline, node);\n" +
                "                xmlAddChild(nodeblocks, nodeline);\n" +
                "            }\n" +
                "\n" +
                "            xmlAddChild(printSpace, nodeblocks);\n" +
                "        }\n" +
                "\n" +
                "        delete lineNumberWords;\n" +
                "    }\n" +
                "\n" +
                "    for(parIdx = 0; parIdx < blocks->getLength(); parIdx++) {\n" +
                "        par = (TextParagraph *) blocks->get(parIdx);\n" +
                "\n" +
                "        nodeblocks = xmlNewNode(NULL, (const xmlChar *) TAG_BLOCK);\n" +
                "        nodeblocks->type = XML_ELEMENT_NODE;\n" +
                "\n" +
                "        id = new GString(\"p\");\n" +
                "        xmlNewProp(nodeblocks, (const xmlChar *) ATTR_ID,\n" +
                "                   (const xmlChar *) buildIdBlock(num, numBlock, id)->getCString());\n" +
                "        delete id;\n" +
                "        numBlock = numBlock + 1;\n" +
                "\n" +
                "        char *tmp;\n" +
                "        tmp = (char *) malloc(10 * sizeof(char));\n" +
                "        snprintf(tmp, sizeof(tmp),ATTR_NUMFORMAT, par->getXMin());\n" +
                "        xmlNewProp(nodeblocks, (const xmlChar*)ATTR_X, (const xmlChar*)tmp);\n" +
                "        snprintf(tmp, sizeof(tmp),ATTR_NUMFORMAT, par->getYMin());\n" +
                "        xmlNewProp(nodeblocks, (const xmlChar*)ATTR_Y, (const xmlChar*)tmp);\n" +
                "        snprintf(tmp, sizeof(tmp),ATTR_NUMFORMAT, par->getYMax() - par->getYMin());\n" +
                "        xmlNewProp(nodeblocks, (const xmlChar*)ATTR_HEIGHT, (const xmlChar*)tmp);\n" +
                "        snprintf(tmp, sizeof(tmp),ATTR_NUMFORMAT, par->getXMax() - par->getXMin());\n" +
                "        xmlNewProp(nodeblocks, (const xmlChar*)ATTR_WIDTH, (const xmlChar*)tmp);\n" +
                "        free(tmp);\n" +
                "\n" +
                "        for (lineIdx = 0; lineIdx < par->lines->getLength(); lineIdx++) {\n" +
                "            line1 = (TextLine *) par->lines->get(lineIdx);\n" +
                "\n" +
                "            // this is the max font size for the line\n" +
                "            double lineFontSize = line1->fontSize;\n" +
                "\n" +
                "            nodeline = xmlNewNode(NULL, (const xmlChar *) TAG_TEXT);\n" +
                "            nodeline->type = XML_ELEMENT_NODE;\n" +
                "\n" +
                "            char *tmp;\n" +
                "\n" +
                "            tmp = (char *) malloc(10 * sizeof(char));\n" +
                "\n" +
                "            snprintf(tmp, sizeof(tmp),ATTR_NUMFORMAT, line1->getXMax() - line1->getXMin());\n" +
                "            xmlNewProp(nodeline, (const xmlChar*)ATTR_WIDTH, (const xmlChar*)tmp);\n" +
                "            snprintf(tmp, sizeof(tmp),ATTR_NUMFORMAT, line1->getYMax() - line1->getYMin());\n" +
                "            xmlNewProp(nodeline, (const xmlChar*)ATTR_HEIGHT, (const xmlChar*)tmp);\n" +
                "\n" +
                "\n" +
                "            // Add the ID attribute for the TEXT tag\n" +
                "            id = new GString(\"p\");\n" +
                "            xmlNewProp(nodeline, (const xmlChar*)ATTR_ID,\n" +
                "                       (const xmlChar*)buildIdText(num, numText, id)->getCString());\n" +
                "            delete id;\n" +
                "            numText = numText + 1;\n" +
                "\n" +
                "            snprintf(tmp, sizeof(tmp),ATTR_NUMFORMAT, line1->getXMin());\n" +
                "            xmlNewProp(nodeline, (const xmlChar*)ATTR_X, (const xmlChar*)tmp);\n" +
                "\n" +
                "            snprintf(tmp, sizeof(tmp),ATTR_NUMFORMAT, line1->getYMin());\n" +
                "            xmlNewProp(nodeline, (const xmlChar*)ATTR_Y, (const xmlChar*)tmp);\n" +
                "\n" +
                "            free(tmp);\n" +
                "\n" +
                "            n = line1->len;\n" +
                "            if (line1->hyphenated && lineIdx + 1 < par->lines->getLength()) {\n" +
                "                --n;\n" +
                "            }\n" +
                "\n" +
                "            for (wordI = 0; wordI < line1->words->getLength(); wordI++) {\n" +
                "                word = (TextWord *) line1->words->get(wordI);\n" +
                "                if (wordI < line1->words->getLength() - 1)\n" +
                "                    nextWord = (TextWord *) line1->words->get(wordI + 1);\n" +
                "\n" +
                "                char *tmp;\n" +
                "\n" +
                "                tmp = (char *) malloc(10 * sizeof(char));\n" +
                "\n" +
                "                fontStyleInfo = new TextFontStyleInfo;\n" +
                "\n" +
                "                node = xmlNewNode(NULL, (const xmlChar *) TAG_TOKEN);\n" +
                "\n" +
                "                node->type = XML_ELEMENT_NODE;\n" +
                "\n" +
                "                // determine if the current token is superscript of subscript: a general constraint for superscript and subscript\n" +
                "                // is that the scripted tokens have a font size smaller than the tokens on the line baseline.\n" +
                "\n" +
                "                // superscript\n" +
                "                if (currentLineBaseLine != 0 &&\n" +
                "                    wordI > 0 &&\n" +
                "                    word->base < currentLineBaseLine &&\n" +
                "                    word->yMax > currentLineYmin &&\n" +
                "                    word->fontSize < lineFontSize) {\n" +
                "                    // superscript: general case, not at the beginning of a line\n" +
                "                    fontStyleInfo->setIsSuperscript(gTrue);\n" +
                "                }\n" +
                "                else if (wordI == 0 &&\n" +
                "                    wordI < line1->words->getLength() - 1 &&\n" +
                "                    nextWord != NULL &&\n" +
                "                    word->base < nextWord->base &&\n" +
                "                    word->yMax > nextWord->yMin &&\n" +
                "                    word->fontSize < lineFontSize) {\n" +
                "                    // superscript: case first token of the line, check if the current token is the first token of the line \n" +
                "                    // and use next tokens to see if we have a vertical shift\n" +
                "                    // note: it won't work when we have several tokens in superscript at the beginning of the line...\n" +
                "                    // actually it might screw all the rest :/\n" +
                "                    // superscript as first token of a line is common for declaring affiliations (and sometime references)\n" +
                "                    fontStyleInfo->setIsSuperscript(gTrue);\n" +
                "                    currentLineBaseLine = nextWord->base;\n" +
                "                    currentLineYmin = nextWord->yMin;\n" +
                "                    currentLineYmax = nextWord->yMax;\n" +
                "                }\n" +
                "                else if (wordI > 0 &&\n" +
                "                    word->base > currentLineBaseLine &&\n" +
                "                    word->yMin < currentLineYmax &&\n" +
                "                    word->fontSize < lineFontSize) {\n" +
                "                    // common subscript, not at the beginning of a line\n" +
                "                    fontStyleInfo->setIsSubscript(gTrue);\n" +
                "                }\n" +
                "                else if (wordI == 0 &&\n" +
                "                    wordI < line1->words->getLength() - 1 &&\n" +
                "                    nextWord != NULL &&\n" +
                "                    word->base > nextWord->base &&\n" +
                "                    word->yMin < nextWord->yMax &&\n" +
                "                    word->fontSize < lineFontSize) {\n" +
                "                    // subscript: case first token of the line, check if the current token is the first token of the line \n" +
                "                    // and use next tokens to see if we have a vertical shift\n" +
                "                    // note: it won't work when we have several tokens in subscripts at the beginning of the line...\n" +
                "                    // actually it might screw all the rest :/\n" +
                "                    // subscript as first token of a line should never appear, but it's better to cover this case to \n" +
                "                    // avoid having the rest of the line detected as superscript... \n" +
                "                    fontStyleInfo->setIsSubscript(gTrue);\n" +
                "                    currentLineBaseLine = nextWord->base;\n" +
                "                    currentLineYmin = nextWord->yMin;\n" +
                "                    currentLineYmax = nextWord->yMax;\n" +
                "                }\n" +
                "                // PL: above, we need to pay attention to the font style of the previous token and consider the whole line, \n" +
                "                // because otherwise the token next to a subscript is always superscript even when normal, in addition for \n" +
                "                // several tokens as superscript or subscript, only the first one will be set as superscript or subscript\n" +
                "\n" +
                "                // if option verbose is selected\n" +
                "                if (verbose) {\n" +
                "                    addAttributsNodeVerbose(node, tmp, word);\n" +
                "                }\n" +
                "                addAttributsNode(node, word, fontStyleInfo, uMap, fullFontName);\n" +
                "                addAttributTypeReadingOrder(node, tmp, word);\n" +
                "\n" +
                "//                    encodeFragment(line->text, n, uMap, primaryLR, s);\n" +
                "//                    if (lineIdx + 1 < par->lines->getLength() && !line->hyphenated) {\n" +
                "//                        s->append(space, spaceLen);\n" +
                "//                    }\n" +
                "\n" +
                "                // Add next images inline whithin the current line if the noImageInline option is not selected\n" +
                "                if (parameters->getImageInline()) {\n" +
                "                    if (indiceImage != -1) {\n" +
                "                        int nb = listeImageInline.size();\n" +
                "                        for (; indiceImage < nb; indiceImage++) {\n" +
                "                            if (idWORDBefore\n" +
                "                                == listeImageInline[indiceImage]->idWordBefore) {\n" +
                "                                nodeImageInline = xmlNewNode(NULL,\n" +
                "                                                             (const xmlChar *) TAG_TOKEN);\n" +
                "                                nodeImageInline->type = XML_ELEMENT_NODE;\n" +
                "                                id = new GString(\"p\");\n" +
                "                                xmlNewProp(nodeImageInline, (const xmlChar *) ATTR_ID,\n" +
                "                                           (const xmlChar *) buildIdToken(num, numToken, id)->getCString());\n" +
                "                                delete id;\n" +
                "                                numToken = numToken + 1;\n" +
                "                                id = new GString(\"p\");\n" +
                "                                xmlNewProp(\n" +
                "                                        nodeImageInline,\n" +
                "                                        (const xmlChar *) ATTR_SID,\n" +
                "                                        (const xmlChar *) buildSID(num, listeImageInline[indiceImage]->getIdx(),\n" +
                "                                                                   id)->getCString());\n" +
                "                                delete id;\n" +
                "                                snprintf(tmp, sizeof(tmp), ATTR_NUMFORMAT,\n" +
                "                                        listeImageInline[indiceImage]->getXPositionImage());\n" +
                "                                xmlNewProp(nodeImageInline, (const xmlChar *) ATTR_X,\n" +
                "                                           (const xmlChar *) tmp);\n" +
                "                                snprintf(tmp, sizeof(tmp), ATTR_NUMFORMAT,\n" +
                "                                        listeImageInline[indiceImage]->getYPositionImage());\n" +
                "                                xmlNewProp(nodeImageInline, (const xmlChar *) ATTR_Y,\n" +
                "                                           (const xmlChar *) tmp);\n" +
                "                                snprintf(tmp, sizeof(tmp), ATTR_NUMFORMAT,\n" +
                "                                         listeImageInline[indiceImage]->getWidthImage());\n" +
                "                                xmlNewProp(nodeImageInline, (const xmlChar *) ATTR_WIDTH,\n" +
                "                                           (const xmlChar *) tmp);\n" +
                "                                snprintf(tmp, sizeof(tmp), ATTR_NUMFORMAT,\n" +
                "                                         listeImageInline[indiceImage]->getHeightImage());\n" +
                "                                xmlNewProp(nodeImageInline,\n" +
                "                                           (const xmlChar *) ATTR_HEIGHT,\n" +
                "                                           (const xmlChar *) tmp);\n" +
                "                                xmlNewProp(\n" +
                "                                        nodeImageInline,\n" +
                "                                        (const xmlChar *) ATTR_HREF,\n" +
                "                                        (const xmlChar *) listeImageInline[indiceImage]->getHrefImage()->getCString());\n" +
                "                                xmlAddChild(nodeline, nodeImageInline);\n" +
                "                            }\n" +
                "                        }\n" +
                "                    }\n" +
                "                }\n" +
                "\n" +
                "                // Include a TOKEN tag for the image inline if it exists\n" +
                "                if (!parameters->getImageInline()) {\n" +
                "                    addImageInlineNode(nodeline, nodeImageInline, tmp, word);\n" +
                "                }\n" +
                "\n" +
                "                //testLinkedText(nodeline,minLineX,minLineY,minLineX+lineWidth,minLineY+lineHeight);\n" +
                "//\t\t\t    if (testAnnotatedText(minLineX,minLineY,minLineX+lineWidth,minLineY+lineHeight)){\n" +
                "//\t\t\t\t    xmlNewProp(nodeline, (const xmlChar*)ATTR_HIGHLIGHT,(const xmlChar*)\"yes\");\n" +
                "//\t\t\t    }\n" +
                "\n" +
                "                if (word->lineNumber == false || (!is_number(word)))\n" +
                "                    xmlAddChild(nodeline, node);\n" +
                "\n" +
                "                if (wordI < line1->words->getLength() - 1 and (word->spaceAfter == gTrue)) {\n" +
                "                    xmlNodePtr spacingNode = xmlNewNode(NULL, (const xmlChar *) TAG_SPACING);\n" +
                "                    spacingNode->type = XML_ELEMENT_NODE;\n" +
                "                    snprintf(tmp, sizeof(tmp), ATTR_NUMFORMAT, (nextWord->xMin - word->xMax));\n" +
                "                    xmlNewProp(spacingNode, (const xmlChar *) ATTR_WIDTH,\n" +
                "                               (const xmlChar *) tmp);\n" +
                "                    snprintf(tmp, sizeof(tmp), ATTR_NUMFORMAT, (word->yMin));\n" +
                "                    xmlNewProp(spacingNode, (const xmlChar *) ATTR_Y,\n" +
                "                               (const xmlChar *) tmp);\n" +
                "                    snprintf(tmp, sizeof(tmp), ATTR_NUMFORMAT, (word->xMax));\n" +
                "                    xmlNewProp(spacingNode, (const xmlChar *) ATTR_X,\n" +
                "                               (const xmlChar *) tmp);\n" +
                "\n" +
                "                    xmlAddChild(nodeline, spacingNode);\n" +
                "                }\n" +
                "\n" +
                "                if (!fontStyleInfo->isSuperscript() && !fontStyleInfo->isSubscript()) {\n" +
                "                    currentLineBaseLine = word->base;\n" +
                "                    currentLineYmin = word->yMin;\n" +
                "                    currentLineYmax = word->yMax;\n" +
                "                }\n" +
                "                previousWordBaseLine = word->base;\n" +
                "                previousWordYmin = word->yMin;\n" +
                "                previousWordYmax = word->yMax;\n" +
                "\n" +
                "                free(tmp);\n" +
                "            }\n" +
                "\n" +
                "            xmlAddChild(nodeblocks, nodeline);\n" +
                "        }\n" +
                "\n" +
                "        xmlAddChild(printSpace, nodeblocks);\n" +
                "    }\n" +
                "\n" +
                "    int imageCount = listeImages.size();\n" +
                "    for (int i = 0; i < imageCount; ++i) {\n" +
                "\n" +
                "        char *tmp;\n" +
                "\n" +
                "        tmp = (char *) malloc(10 * sizeof(char));\n" +
                "\n" +
                "        node = xmlNewNode(NULL, (const xmlChar *) TAG_IMAGE);\n" +
                "        xmlNewProp(node, (const xmlChar *) ATTR_ID, (const xmlChar *) listeImages[i]->getImageId()->getCString());\n" +
                "\n" +
                "\n" +
                "        //xmlNewProp(node, (const xmlChar *) ATTR_SID,(const xmlChar*)listeImages[i]->getImageSid()->getCString());\n" +
                "\n" +
                "\n" +
                "        snprintf(tmp, sizeof(tmp), ATTR_NUMFORMAT, listeImages[i]->getXPositionImage());\n" +
                "        xmlNewProp(node, (const xmlChar *) ATTR_X, (const xmlChar *) tmp);\n" +
                "        snprintf(tmp, sizeof(tmp), ATTR_NUMFORMAT, listeImages[i]->getYPositionImage());\n" +
                "        xmlNewProp(node, (const xmlChar *) ATTR_Y, (const xmlChar *) tmp);\n" +
                "        snprintf(tmp, sizeof(tmp), ATTR_NUMFORMAT, listeImages[i]->getWidthImage());\n" +
                "        xmlNewProp(node, (const xmlChar *) ATTR_WIDTH, (const xmlChar *) tmp);\n" +
                "        snprintf(tmp, sizeof(tmp), ATTR_NUMFORMAT, listeImages[i]->getHeightImage());\n" +
                "        xmlNewProp(node, (const xmlChar *) ATTR_HEIGHT, (const xmlChar *) tmp);\n" +
                "\n" +
                "        std::string rotation = std::to_string(listeImages[i]->getRotation());\n" +
                "        xmlNewProp(node,(const xmlChar*)ATTR_ROTATION,(const xmlChar*)rotation.c_str());\n" +
                "        //if (listeImages[i]->getRotation() > 0){\n" +
                "        //    xmlNewProp(node,(const xmlChar*)ATTR_ROTATION,(const xmlChar*)sTRUE);\n" +
                "        //}\n" +
                "        //else{\n" +
                "        //    xmlNewProp(node,(const xmlChar*)ATTR_ROTATION,(const xmlChar*)sFALSE);\n" +
                "        //}\n" +
                "\n" +
                "//        if (listeImages[i]->isImageInline()) {\n" +
                "//            xmlNewProp(node, (const xmlChar *) ATTR_INLINE, (const xmlChar *) sTRUE);\n" +
                "//        }\n" +
                "        xmlNewProp(node, (const xmlChar *) ATTR_HREF,\n" +
                "                   (const xmlChar *) listeImages[i]->getHrefImage()->getCString());\n" +
                "\n" +
                "        xmlNewProp(node, (const xmlChar *) ATTR_TYPE,\n" +
                "                   (const xmlChar *) listeImages[i]->getType()->getCString());\n" +
                "        if (verbose) {\n" +
                "            xmlNewProp(node, (const xmlChar *) ATTR_CLIPZONE,\n" +
                "                       (const xmlChar *) listeImages[i]->getClipZone()->getCString());\n" +
                "        }\n" +
                "        xmlAddChild(printSpace, node);\n" +
                "        free(tmp);\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    if (parameters->getDisplayImage()) {\n" +
                "        GString *sid = new GString(\"p\");\n" +
                "        GBool isInline = false;\n" +
                "        sid = buildSID(getPageNumber(), getIdx(), sid);\n" +
                "\n" +
                "        GString *relname = new GString(dataDirectory);\n" +
                "        relname->append(\"-\");\n" +
                "        relname->append(GString::fromInt(num));\n" +
                "        relname->append(EXTENSION_SVG);\n" +
                "        char *tmp;\n" +
                "\n" +
                "        tmp = (char *) malloc(10 * sizeof(char));\n" +
                "\n" +
                "        node = xmlNewNode(NULL, (const xmlChar *) TAG_IMAGE);\n" +
                "        xmlNewProp(node, (const xmlChar *) ATTR_ID,\n" +
                "                   (const xmlChar *) sid->getCString());\n" +
                "\n" +
                "        //xmlNewProp(node, (const xmlChar *) ATTR_SID,(const xmlChar*)listeImages[i]->getImageSid()->getCString());\n" +
                "\n" +
                "        double r =0;\n" +
                "        snprintf(tmp, sizeof(tmp), ATTR_NUMFORMAT, svg_xmin);\n" +
                "        xmlNewProp(node, (const xmlChar *) ATTR_X, (const xmlChar *) tmp);\n" +
                "        snprintf(tmp, sizeof(tmp), ATTR_NUMFORMAT, svg_ymin);\n" +
                "        xmlNewProp(node, (const xmlChar *) ATTR_Y, (const xmlChar *) tmp);\n" +
                "        snprintf(tmp, sizeof(tmp), ATTR_NUMFORMAT, svg_xmax - svg_xmin);\n" +
                "        xmlNewProp(node, (const xmlChar *) ATTR_WIDTH, (const xmlChar *) tmp);\n" +
                "        snprintf(tmp, sizeof(tmp), ATTR_NUMFORMAT, svg_ymax - svg_ymin);\n" +
                "        xmlNewProp(node, (const xmlChar *) ATTR_HEIGHT, (const xmlChar *) tmp);\n" +
                "\n" +
                "        std::string rotation = std::to_string(r);\n" +
                "        xmlNewProp(node,(const xmlChar*)ATTR_ROTATION,(const xmlChar*)rotation.c_str());\n" +
                "        //if (r > 0) {\n" +
                "        //    xmlNewProp(node, (const xmlChar *) ATTR_ROTATION, (const xmlChar *) sTRUE);\n" +
                "        //} else {\n" +
                "        //    xmlNewProp(node, (const xmlChar *) ATTR_ROTATION, (const xmlChar *) sFALSE);\n" +
                "        //}\n" +
                "\n" +
                "//        if (listeImages[i]->isImageInline()) {\n" +
                "//            xmlNewProp(node, (const xmlChar *) ATTR_INLINE, (const xmlChar *) sTRUE);\n" +
                "//        }\n" +
                "        xmlNewProp(node, (const xmlChar *) ATTR_HREF,\n" +
                "                   (const xmlChar *) relname->getCString());\n" +
                "\n" +
                "        xmlNewProp(node, (const xmlChar *) ATTR_TYPE,\n" +
                "                   (const xmlChar *) \"svg\");\n" +
                "        xmlAddChild(printSpace, node);\n" +
                "        free(tmp);\n" +
                "\n" +
                "        // Save the file for example with relname 'p_06.xml_data/image-27.vec'\n" +
                "        if (!xmlSaveFile(relname->getCString(), vecdoc)) {\n" +
                "            //error(errIO,-1, \"Couldn't open file '%s'\", relname->getCString());\n" +
                "        }\n" +
                "        xmlFreeDoc(vecdoc);\n" +
                "    }\n" +
                "\n" +
                "    uMap->decRefCnt();\n" +
                "}\n" +
                "\n" +
                "// PL: Insert a block in the page's block list according to the reading order\n" +
                "// lastInserted: true if the previously added block has been inserted and not appended\n" +
                "GBool TextPage::addBlockInReadingOrder(TextParagraph *block, double fontSize, GBool lastInserted) {";

        List<String> result = getSubContentsByProperty(content, "dump");

        result.stream().forEach(System.out::println);

    }

    /**
     * @param content  文件内容
     * @param property 函数名字
     * @return
     */
    private List<String> getSubContentsByProperty(String content, String property) {

        Pattern pattern = Pattern.compile(property + "\\s*\\([\\w,\\s*<>]*\\)\\s*\\{");
        Matcher matcher = pattern.matcher(content);
        int length = content.length();
        int start;
        List<String> subContents = new ArrayList<>();
        while (matcher.find()) {
            start = matcher.start();
            int end = start;
            int count = 0;
            for (int i = start; i < length; i++) {
                char c = content.charAt(i);
                if (c != '{' && c != '}') continue;
                else if (c == '{') {
                    count++;
                    continue;
                } else {
                    count--;
                }

                if (count == 0) {
                    end = i;
                    break;
                }
            }
            subContents.add(content.substring(start, end + 1));
        }
        return subContents;
    }


    /**
     * 测试解析.csproj中依赖
     */
    @Test
    public void test5() {
        String content = "<PropertyGroup Condition=\" '$(Configuration)|$(Platform)' == 'Release|AnyCPU' \">\n" +
                "    <PlatformTarget>AnyCPU</PlatformTarget>\n" +
                "    <DebugType>pdbonly</DebugType>\n" +
                "    <Optimize>true</Optimize>\n" +
                "    <OutputPath>bin\\Release\\</OutputPath>\n" +
                "    <DefineConstants>TRACE</DefineConstants>\n" +
                "    <ErrorReport>prompt</ErrorReport>\n" +
                "    <WarningLevel>4</WarningLevel>\n" +
                "  </PropertyGroup>\n" +
                "  <ItemGroup>\n" +
                "    <PackageReference Include=\"YamlDotNet\" Version=\"4.3.2\" />\n" +
                "    <PackageReference Include=\"Common.Logging\" Version=\"3.4.1\" />\n" +
                "  </ItemGroup>\n" +
                "  <ItemGroup>\n" +
                "    <Compile Include=\"Program.cs\" />\n" +
                "    <Compile Include=\"Properties\\AssemblyInfo.cs\" />\n" +
                "  </ItemGroup>";

        Pattern pattern = Pattern.compile("<PackageReference\\s+Include=\"(\\S+)(?=\")\"\\s+Version=\"(\\S+)(?=\")");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }
    }

    /**
     * 测试packages.config中依赖
     */
    @Test
    public void test6() {
        String content = "\uFEFF<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<packages>\n" +
                "  <package id=\"Common.Logging\" version=\"3.4.1\" targetFramework=\"net45\" />\n" +
                "  <package id=\"Common.Logging.Core\" version=\"3.4.1\" targetFramework=\"net45\" />\n" +
                "  <package id=\"Microsoft.CSharp\" version=\"4.0.1\" targetFramework=\"net45\" />\n" +
                "  <package id=\"YamlDotNet\" version=\"4.3.2\" targetFramework=\"net45\" />\n" +
                "</packages>";
        Pattern pattern = Pattern.compile("<package\\s+id=\"(\\S+)(?=\")\"\\s+version=\"(\\S+)(?=\")");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }
    }

    /**
     * 测试cocoapods Podfile解析
     */
    @Test
    public void test7() {
        String content = "1target 'only-podfile' do\n" +
                "2  use_frameworks!\n" +
                "3\n" +
                "3  pod 'ReactiveCocoa', '5.0.0-rc.1'\n" +
                "4  pod 'Alamofire', '~> 4.0'\n" +
                "5  pod 'HockeyKit'\n" +
                "6  pod 'OpenSSL-Static', '1.0.2.c1'\n" +
                "7\n" +
                "8end";

//        content = "# Uncomment the next line to define a global platform for your project\n" +
//                "# platform :ios, '9.0'\n" +
//                "\n" +
//                "target 'ManualSignExample' do\n" +
//                "  use_frameworks!\n" +
//                "  pod 'OneSignal', '>= 2.5.2', '< 3.0'\n" +
//                "end\n" +
//                "\n" +
//                "target 'OneSignalNotificationServiceExtension' do\n" +
//                "  use_frameworks!\n" +
//                "  pod 'OneSignal', '>= 2.5.2', '< 3.0'\n" +
//                "end";

        // 有版本号
        Pattern pattern = Pattern.compile("(\\d+)\\s*pod\\s+\'(\\S+)(?=\')\'(\\s*,\\s*\'([\\S\\s]+?)(?=\')\'(\\s*,\\s*\'([\\S\\s]+?)(?=\'))?)?");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group(5));
        }

//        // 无版本号
//        Pattern pattern1 = Pattern.compile("pod\\s+\'(\\S+)(?=\')\'(?!,)");
//        Matcher matcher1 = pattern1.matcher(content);
//        while (matcher1.find()) {
//            System.out.println(matcher1.group(1));
//        }
    }

    /**
     * 测试Podfile.lock文件
     */
    @Test
    public void test8() {
        String content = "PODS:\n" +
                "  - AFMSlidingCell (1.0.0)\n" +
                "  - Bolts (1.3.0):\n" +
                "    - Bolts/AppLinks (= 1.3.0)\n" +
                "    - Bolts/Tasks (= 1.3.0)\n" +
                "  - Bolts/AppLinks (1.3.0):\n" +
                "    - Bolts/Tasks\n" +
                "  - Bolts/Tasks (1.3.0)\n" +
                "  - Fabric (1.2.8):\n" +
                "    - Fabric/Base (= 1.2.8)\n" +
                "  - Fabric/Base (1.2.8)\n" +
                "  - FBSDKCoreKit (4.6.0):\n" +
                "    - Bolts (~> 1.1)\n" +
                "    - FBSDKCoreKit/arc (= 4.6.0)\n" +
                "    - FBSDKCoreKit/no-arc (= 4.6.0)\n" +
                "  - FBSDKCoreKit/arc (4.6.0):\n" +
                "    - Bolts (~> 1.1)\n" +
                "  - FBSDKCoreKit/no-arc (4.6.0):\n" +
                "    - Bolts (~> 1.1)\n" +
                "    - FBSDKCoreKit/arc\n" +
                "  - FBSDKLoginKit (4.6.0):\n" +
                "    - FBSDKCoreKit\n" +
                "  - FBSDKShareKit (4.6.0):\n" +
                "    - FBSDKCoreKit\n" +
                "  - LSSwipeToDeleteCollectionViewLayout (0.1.6)\n" +
                "  - Reachability (3.2)\n" +
                "  - TwitterCore (1.9.0)\n" +
                "  - TwitterKit (1.9.0)\n" +
                "  - VK-ios-sdk (1.1.12)\n" +
                "\n" +
                "DEPENDENCIES:\n" +
                "  - AFMSlidingCell (~> 1.0)\n" +
                "  - Fabric\n" +
                "  - FBSDKCoreKit (~> 4.6)\n" +
                "  - FBSDKLoginKit (~> 4.6)\n" +
                "  - FBSDKShareKit (~> 4.6)\n" +
                "  - LSSwipeToDeleteCollectionViewLayout (~> 0.1)\n" +
                "  - Reachability (~> 3.2)\n" +
                "  - TwitterCore\n" +
                "  - TwitterKit\n" +
                "  - VK-ios-sdk (~> 1.1)\n";

        content = MatchUtil.addLineNumber(content);

        Pattern pattern = Pattern.compile("PODS:[\\s\\S]+?(?=\n\\d+\n)");
        Matcher matcher = pattern.matcher(content);
        String PodsContent = null;
        if (matcher.find()) {
            PodsContent = matcher.group();
            System.out.println(PodsContent);
        }
        if (PodsContent == null) {

        }

        Pattern pattern1 = Pattern.compile("(\\d+)\\s*-\\s+(\\S+)\\s+\\((\\S+)\\)");
        Matcher matcher1 = pattern1.matcher(PodsContent);
        while (matcher1.find()) {
            String name = matcher1.group(1);
            if (name.contains("/")) continue;
            String version = matcher1.group(2);
            System.out.println(matcher1.group());

        }
    }

    /**
     * 测试^
     */
    @Test
    public void test9() {
        String versionStatement = "~= 1.2.3";
        boolean flag = Pattern.compile("^[~><]").matcher(versionStatement).find();
        Assert.assertTrue(flag);

    }



    @Test
    public void test12() {

        String content1 = "ThisBuild / organization := \"com.example\"\n" +
                "ThisBuild / version      := \"0.1.0-SNAPSHOT\"\n" +
                "ThisBuild / scalaVersion := \"2.12.10\"\n" +
                "\n" +
                "lazy val core = (project in file(\"core\"))\n" +
                "  .settings(\n" +
                "    // other settings\n" +
                "  )\n" +
                "\n" +
                "lazy val util = (project in file(\"util\"))\n" +
                "  .settings(\n" +
                "    // other settings\n" +
                "  )";

        String content2 = "name := \"multi-projects\"\n" +
                "\n" +
                "version := \"1.0\"\n" +
                "\n" +
                "scalaVersion := \"2.11.8\"\n" +
                "\n" +
                "lazy val utils = project\n" +
                "\n" +
                "lazy val app = project.\n" +
                "  dependsOn(utils)";


        Matcher name_matcher = Pattern.compile("(?:name|organization)\\s*:=\\s*\"(\\S+)(?=\")").matcher(content1);
        String name;
        if (name_matcher.find()) {
            name = name_matcher.group(1).trim();
        } else {
            // 没有找到模组名
        }

        Matcher sub_module_matcher = Pattern.compile("val\\s*(\\S+)\\s*=.*?(?=project)").matcher(content1);
        while (sub_module_matcher.find()) {
            System.out.println(sub_module_matcher.group(1));
        }
    }



    @Test
    public void testsql() {
        String content = "SELECT pr_rule.*,sys_task_rule.`rule_type`,sys_task_rule.`interval_time`,sys_task_rule.`cron_exp` FROM (\n" +
                "SELECT pre_pr.*,parse_rule.`rule_name`,parse_rule.`dependency_depth`,parse_rule.`default_rule` FROM (\n" +
                "SELECT sub_1.*,COUNT(CASE WHEN vul_level=\"4\" THEN vul_level END) level4,COUNT(CASE WHEN vul_level=\"3\" THEN vul_level END) level3,COUNT(CASE WHEN vul_level=\"2\" THEN vul_level END) level2,COUNT(CASE WHEN vul_level=\"1\" THEN vul_level END) level1,COUNT(CASE WHEN vul_level=\"0\" THEN vul_level END) level0 FROM (\n" +
                "SELECT sub.*,count(repo_items.repo_name) AS lib_number,count(DISTINCT repo_items.license) AS license_types FROM (\n" +
                "SELECT UUID() AS id,prod.NAME AS product_name,prod.id AS product_id,ptask.*FROM (\n" +
                "SELECT id,NAME FROM product WHERE user_id=189) prod LEFT JOIN (\n" +
                "SELECT t.*,p.`product_id` AS pd_id,p.NAME,p.`create_time`,p.`last_scan`,p.`url`,p.`project_source`,p.`rule_id` FROM project p,(\n" +
                "SELECT id AS tid,project_id,msg,STATUS,`progress` FROM sys_task WHERE id IN (\n" +
                "SELECT MAX(id) AS id FROM sys_task GROUP BY project_id)) t WHERE t.project_id=p.id) ptask ON prod.id=ptask.pd_id) sub LEFT JOIN repo_items ON sub.project_id=repo_items.project_id GROUP BY IFNULL(sub.project_id,UUID())) sub_1 LEFT JOIN defects USING (project_id) GROUP BY IFNULL(sub_1.project_id,UUID())) pre_pr LEFT JOIN parse_rule ON pre_pr.rule_id=parse_rule.id) pr_rule LEFT JOIN sys_task_rule ON pr_rule.project_id=sys_task_rule.project_id WHERE (\n" +
                "SELECT IF (LENGTH(TRIM(\"\"))> 0,pr_rule.NAME LIKE '%' '%',1=1)) ORDER BY create_time DESC";

        System.out.println(content.trim().replaceAll("\n",""));
    }
}
