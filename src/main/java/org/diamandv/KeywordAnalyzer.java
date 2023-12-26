package org.diamandv;

abstract class KeywordAnalyzer implements TextAnalyzer {

    abstract protected String[] getKeywords();

    abstract protected Label getLabel();

    @Override
    public Label processText(String text) {
        for (String keyword : getKeywords()) {
            if (text.contains(keyword))
                return getLabel();
        }
        return Label.OK;
    }
}

class SpamAnalyzer extends KeywordAnalyzer {
    private String[] keywords;
    private Label label;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords.clone();
        label = Label.SPAM;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return label;
    }
}

class NegativeTextAnalyzer extends KeywordAnalyzer {
    private String[] keywords;
    private Label label;

    public NegativeTextAnalyzer() {
        this.keywords = new String[]{":(", "=(", ":|"};
        label = Label.NEGATIVE_TEXT;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return label;
    }

}

class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        if (text.length() > maxLength)
            return Label.TOO_LONG;
        return Label.OK;
    }

}

public Label checkLabels(TextAnalyzer[] analyzers, String text) {
    for (TextAnalyzer analyzer : analyzers) {
        if (analyzer.processText(text) != Label.OK) return analyzer.processText(text);
    }
    return Label.OK;
}