"""
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
"""

class MatchMaker: 
    def __init__(self, explainers, interpreters): 
        self.explainers = explainers 
        self.interpreters = interpreters 

    def find_match(self, new_explainer) -> List['Interpreter']: 
        # new_explainer has parameter tags which is a list of strings.
        # each interpreter in self.interpreter has parameter tags which is a list of strings. 
        pass 
