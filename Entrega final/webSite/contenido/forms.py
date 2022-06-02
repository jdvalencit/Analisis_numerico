from django import forms
error_types = [
    ("abs","Absolute"),
    ("rel","Relative")
]
class formFP(forms.Form):
    f = forms.CharField()
    g = forms.CharField()
    xi = forms.CharField()
    tol = forms.CharField()
    n = forms.CharField()
    errorType = forms.CharField(label="Error type", widget=forms.Select(choices=error_types))

class formIS(forms.Form):
    f = forms.CharField()
    xi = forms.CharField()
    dx = forms.CharField()
    n = forms.CharField()

class formFXXTOL(forms.Form):
    f = forms.CharField()
    xi = forms.CharField()
    xf = forms.CharField()
    tol = forms.CharField()
    n = forms.CharField()
    errorType = forms.CharField(label="Error type", widget=forms.Select(choices=error_types))

class formNewton(forms.Form):
    f = forms.CharField()
    df = forms.CharField()
    xi = forms.CharField()
    tol = forms.CharField()
    n = forms.CharField()
    errorType = forms.CharField(label="Error type", widget=forms.Select(choices=error_types))

class formSecant(forms.Form):
    f = forms.CharField()
    interval = forms.CharField()
    tol = forms.CharField()
    n = forms.CharField()
    errorType = forms.CharField(label="Error type", widget=forms.Select(choices=error_types))

class formMR(forms.Form):
    f = forms.CharField()
    df = forms.CharField()
    d2f = forms.CharField()
    xi = forms.CharField()
    tol = forms.CharField()
    n = forms.CharField()
    errorType = forms.CharField(label="Error type", widget=forms.Select(choices=error_types))

class formMat(forms.Form):
    matrix = forms.CharField()

class formTP(forms.Form):
    matrix = forms.CharField() 
    b = forms.CharField()
    variables = forms.CharField()

class formAB(forms.Form):
    matrix = forms.CharField()
    b = forms.CharField()

class formITER(forms.Form):
    matrix = forms.CharField()
    b = forms.CharField()
    init = forms.CharField()
    tol = forms.CharField()
    n = forms.CharField()

class formPoints(forms.Form):
    points = forms.CharField()
