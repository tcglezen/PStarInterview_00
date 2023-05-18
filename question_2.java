import java.util.ArrayList;
import java.util.List;

/* 
In our system, we have explainers and interpreters. Explainers take in things such as the underlying model and the dataset and return meaningful data. This data is then visualized in a format that is useful to the user. For example, there is a Shapley explainer which generates the impact that each feature has on the output for a given datapoint. An interpreter for this would be a bar chart since this well visualizes the data. An example of an interpreter that does not work for Shapley feature importance would be a scatter plot. 

As a result each explainer and interpreter will have a set of tags that are used to for pairing explainers and interpreter such that meaningful results are produced. 

Given the following instances: 
Explainers: 
- Shapley 
- ALE
- RIPPER (Rule based learning) 
- Outlier Detection 

Interpreters: 
- Bar chart 
- Scatter plot 
- Table of information 

Create a system which matches the explainers and interpreters. 
*/ 

class MatchMaker {
    private List<Explainer> explainers;
    private List<Interpreter> interpreters;

    public MatchMaker(List<Explainer> explainers, List<Interpreter> interpreters) {
        this.explainers = explainers;
        this.interpreters = interpreters;
    }

    public List<Interpreter> findMatch(Explainer newExplainer) {
        List<Interpreter> matchingInterpreters = new ArrayList<>();

        for (Interpreter interpreter : interpreters) {
            for (String tag : interpreter.getTags()) {
                if (newExplainer.getTags().contains(tag)) {
                    matchingInterpreters.add(interpreter);
                }
            }
        }

        return matchingInterpreters;
    }
}

class Explainer {
    private String name;
    private List<String> tags;

    public Explainer(String name, List<String> tags) {
        this.name = name;
        this.tags = tags;
    }

    public List<String> getTags() {
        return tags;
    }
}

class Interpreter {
    private String name;
    private List<String> tags;

    public Interpreter(String name, List<String> tags) {
        this.name = name;
        this.tags = tags;
    }

    public List<String> getTags() {
        return tags;
    }
}

