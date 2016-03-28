package com.examples.phrase;

public class PhraseFrequency {
    private String phrase;
    private int frequency;

    public PhraseFrequency(String phrase, int frequency) {
        this.phrase = phrase;
        this.frequency = frequency;
    }

    public String getPhrase() {
        return phrase;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + frequency;
        result = prime * result + ((phrase == null) ? 0 : phrase.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PhraseFrequency other = (PhraseFrequency) obj;
        if (frequency != other.frequency)
            return false;
        if (phrase == null) {
            if (other.phrase != null)
                return false;
        } else if (!phrase.equals(other.phrase))
            return false;
        return true;
    }

}
