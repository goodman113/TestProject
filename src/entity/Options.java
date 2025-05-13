package entity;

public class Options {
        private String option;
        private String answer;

    public Options(String option, String answer) {
        this.option = option;
        this.answer = answer;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return option+". "+answer;
    }

}
