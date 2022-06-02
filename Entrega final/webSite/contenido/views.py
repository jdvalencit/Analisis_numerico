import ast
from math import *
import numpy as np
from django.shortcuts import render
from contenido.forms import *
from contenido.metodos.utility import to_aug, create_matrix, create_vector
from contenido.metodos.oneVariable import (
    bisection_method,
    false_rule as false_rule_method,
    fixed_point as fixed_point_method,
    incremental_search as incremental_search_method,
    multiple_roots as multiple_roots_method,
    newton as newton_method,
    secant as secant_method
)
from contenido.metodos.linearSystem import (
    cholesky as cholesky_method,
    crout as crout_method,
    doolittle as doolittle_method,
    gauss_partial_pivot as gauss_partial_pivot_method,
    gauss_total_pivot as gauss_total_pivot_method,
    jacobi as jacobi_method,
    lu_gauss as lu_gauss_elim,
    partial_pivot as partial_pivot_method,
    progressive_substitution as progressive_substitution_method,
    regressive_substitution as regressive_substitution_method,
    seidel as seidel_method,
    simple_gauss,
    total_pivot as total_pivot_method
)
from contenido.metodos.interpolation import (
    splines as splines_method,
    newton_interpolation,
    lagrange_interpolation,
)
# Create your views here.

def home(request):
    return render(request,"index.html")

def bisection(request):
    print("biseccion")
    #f, xlo, xup, tol, err_type="abs"
    if request.method == "POST":
        form_biseccion = formFXXTOL(request.POST)
        if form_biseccion.is_valid():
            data = form_biseccion.cleaned_data
            f = lambda x: eval(data['f'])
            xi = float(data["xi"])
            xf = float(data["xf"])
            tol = float(data["tol"])
            n = int(data["n"])
            err_type = data["errorType"]
            res, table = bisection_method.bisection(f,xi,xf,tol,n,err_type)
            return render(request, "metodos/biseccion.html",{"form":form_biseccion,"res":res,"table":table})
            
    form_biseccion = formFXXTOL()
    return render(request, "metodos/biseccion.html",{"form":form_biseccion})

def fixed_point(request):
    if request.method == "POST":
        form_fixed = formFP(request.POST)
        if form_fixed.is_valid():
            data = form_fixed.cleaned_data
            f = lambda x: eval(data["f"])
            g = lambda x: eval(data["g"])
            x0 = float(data["xi"])
            tol = float(data["tol"])
            n = int(data["n"])
            err_type = data["errorType"]

            res,table = fixed_point_method.fixed_point(f,g,x0,tol,n,err_type)
            return render(request, "metodos/fixed.html", {"form":form_fixed, "res":res,"table":table})

    form_fixed = formFP()
    return render(request, "metodos/fixed.html",{"form":form_fixed})

def incremental_search(request):
    if request.method == "POST":
        form_incremental = formIS(request.POST)
        if form_incremental.is_valid():
            data = form_incremental.cleaned_data
            f = lambda x: eval(data["f"])
            x0 = float(data["xi"])
            dx = float(data["dx"])
            n = int(data["n"])

            res = incremental_search_method.incremental_search(f,x0,dx,n)            
            return render(request, "metodos/incremental.html",{"form":form_incremental,"res":res})
    
    form_incremental = formIS()
    return render(request, "metodos/incremental.html",{"form":form_incremental})

def false_rule(request):
    if request.method == "POST":
        form_false = formFXXTOL(request.POST)
        if form_false.is_valid():
            data = form_false.cleaned_data
            f = lambda x: eval(data["f"])
            xi = float(data["xi"])
            xf = float(data["xf"])
            tol = float(data["tol"])
            n = int(data["n"])
            err_type = data["errorType"]

            res, table = false_rule_method.false_rule(f,xi,xf,tol,n,err_type)  
            return render(request, "metodos/falseRule.html",{"form":form_false,"res":res,"table":table})
    
    form_false = formFXXTOL()
    return render(request, "metodos/falseRule.html",{"form":form_false})

def newton(request):
    if request.method == "POST":
        form_newton = formNewton(request.POST)
        if form_newton.is_valid():
            data = form_newton.cleaned_data
            f = lambda x: eval(data["f"])
            df = lambda x: eval(data["df"])
            x0 = float(data["xi"])
            tol = float(data["tol"])
            n = float(data["n"])
            err_type = data["errorType"]
            res, table = newton_method.newton(f,df,x0,tol,n,err_type)
            return render(request,"metodos/newton.html",{"form":form_newton,"res":res,"table":table})

    form_newton = formNewton()
    return render(request, "metodos/newton.html",{"form":form_newton})


def secant(request):
    if request.method == "POST":
        form_secant = formSecant(request.POST)
        if form_secant.is_valid():
            data = form_secant.cleaned_data
            f = lambda x: eval(data["f"])
            interval = ast.literal_eval(data["interval"])
            tol = float(data["tol"])
            n = int(data["n"])
            err_type = data["errorType"]
            res, table = secant_method.secant(f,interval,tol,n,err_type)
            return render(request,"metodos/secant.html",{"form":form_secant,"res":res,"table":table})

    form_secant = formSecant()
    return render(request, "metodos/secant.html",{"form":form_secant})

def multiple_roots(request):
    if request.method == "POST":
        form_roots = formMR(request.POST)
        if form_roots.is_valid():
            data = form_roots.cleaned_data
            f = lambda x: eval(data["f"])
            df = lambda x: eval(data["df"])
            ddf = lambda x: eval(data["d2f"])
            x0 = float(data["xi"])
            tol = float(data["tol"])
            n = int(data["n"])
            err_type = data["errorType"]
            res, table = multiple_roots_method.multiple_roots(f,df,ddf,x0,tol,n,err_type)
            return render(request,"metodos/multipleRoots.html",{"form":form_roots,"res":res,"table":table})

    form_roots = formMR()
    return render(request, "metodos/multipleRoots.html",{"form":form_roots})





#---------------------------------------------
def progressive_substitution(request):
    if request.method == "POST":
        form_prog = formMat(request.POST)
        if form_prog.is_valid():
            data = form_prog.cleaned_data
            mat = create_matrix(ast.literal_eval(data["matrix"]))
            res = progressive_substitution_method.progressive_substitution(mat)
            return render(request,"metodos/progressiveSubstitution.html",{"form":form_prog,"res":res})

    form_prog = formMat()
    return render(request, "metodos/progressiveSubstitution.html",{"form":form_prog})

def regressive_substitution(request):
    if request.method == "POST":
        form_regressive = formMat(request.POST)
        if form_regressive.is_valid():
            data = form_regressive.cleaned_data
            mat = create_matrix(ast.literal_eval(data["matrix"]))
            res = regressive_substitution_method.regressive_substitution(mat)
            return render(request,"metodos/regressiveSubstitution.html",{"form":form_regressive,"res":res})

    form_regressive = formMat()
    return render(request, "metodos/regressiveSubstitution.html",{"form":form_regressive})

def gauss(request):
    if request.method == "POST":
        form_gauss = formAB(request.POST)
        if form_gauss.is_valid():
            data = form_gauss.cleaned_data

            mat = create_matrix(ast.literal_eval(data["matrix"]))
            b = create_vector(ast.literal_eval(data["b"]))
            res = simple_gauss.simple_gauss(mat,b)
            return render(request,"metodos/gauss.html",{"form":form_gauss,"res":res})

    form_gauss = formAB()
    return render(request, "metodos/gauss.html",{"form":form_gauss})

def partial_pivot(request):
    if request.method == "POST":
        form_partial = formAB(request.POST)
        if form_partial.is_valid():
            data = form_partial.cleaned_data

            mat = create_matrix(ast.literal_eval(data["matrix"]))
            b = create_vector(ast.literal_eval(data["b"]))
            n = mat.shape[0]
            a = to_aug(mat,b)
            for i in range(0,n-1):
                partial_pivot_method.partial_pivot(a,i)
            return render(request,"metodos/partialPivot.html",{"form":form_partial,"res":a})
          
    form_partial = formAB()
    return render(request, "metodos/partialPivot.html",{"form":form_partial})


def total_pivot(request):
    if request.method == "POST":
        form_total = formTP(request.POST)
        if form_total.is_valid():
            data = form_total.cleaned_data

            mat = create_matrix(ast.literal_eval(data["matrix"]))
            b = create_vector(ast.literal_eval(data["b"]))
            n = mat.shape[0]
            a = to_aug(mat,b)
            labels = ast.literal_eval(data["variables"])
            for i in range(0,n-1):
                total_pivot_method.total_pivot(a,i,labels)
            
            return render(request,"metodos/totalPivot.html",{"form":form_total,"res":a})

    form_total = formTP()
    return render(request, "metodos/totalPivot.html",{"form":form_total})

def gauss_partial_pivot(request):
    if request.method == "POST":
        form_gaussP = formAB(request.POST)
        if form_gaussP.is_valid():
            data = form_gaussP.cleaned_data

            mat = create_matrix(ast.literal_eval(data["matrix"]))
            b = create_vector(ast.literal_eval(data["b"]))
            res = gauss_partial_pivot_method.gauss_partial_pivot(mat,b)
            
            return render(request,"metodos/gaussPartial.html",{"form":form_gaussP,"res":res})

    form_gaussP = formAB()
    return render(request, "metodos/gaussPartial.html",{"form":form_gaussP})

def gauss_total_pivot(request):
    if request.method == "POST":
        form_gaussT = formAB(request.POST)
        if form_gaussT.is_valid():
            data = form_gaussT.cleaned_data

            mat = create_matrix(ast.literal_eval(data["matrix"]))
            b = create_vector(ast.literal_eval(data["b"]))
            res, l = gauss_total_pivot_method.gauss_total_pivot(mat,b)
            
            return render(request,"metodos/gaussTotal.html",{"form":form_gaussT,"res":res,"labels":l})

    form_gaussT = formAB()
    return render(request, "metodos/gaussTotal.html",{"form":form_gaussT})

def lu_gauss(request):
    if request.method == "POST":
        form_luGauss = formAB(request.POST)
        if form_luGauss.is_valid():
            data = form_luGauss.cleaned_data

            mat = create_matrix(ast.literal_eval(data["matrix"]))
            b = create_vector(ast.literal_eval(data["b"]))
            res = lu_gauss_elim.lu_gauss(mat,b)
            
            return render(request,"metodos/luGauss.html",{"form":form_luGauss,"res":res})

    form_luGauss = formAB()
    return render(request, "metodos/luGauss.html",{"form":form_luGauss})
    
    
def crout(request):
    if request.method == "POST":
        form_crout = formAB(request.POST)
        if form_crout.is_valid():
            data = form_crout.cleaned_data
            m = create_matrix(ast.literal_eval(data["matrix"]))
            b = create_vector(ast.literal_eval(data["b"]))
            res = crout_method.crout(m,b)
            return render(request,"metodos/crout.html",{"form":form_crout,"res":res})
     
    form_crout = formAB()
    return render(request, "metodos/crout.html",{"form":form_crout})

def doolittle(request):
    if request.method == "POST":
        form_doolittle = formAB(request.POST)
        if form_doolittle.is_valid():
            data = form_doolittle.cleaned_data
            m = create_matrix(ast.literal_eval(data["matrix"]))
            b = create_vector(ast.literal_eval(data["b"]))
            res = doolittle_method.dolittle_fac(m,b)
            return render(request,"metodos/doolittle.html",{"form":form_doolittle,"res":res})

    form_doolittle = formAB()
    return render(request, "metodos/doolittle.html",{"form":form_doolittle})

def cholesky(request):
    if request.method == "POST":
        form_cholesky = formAB(request.POST)
        if form_cholesky.is_valid():
            data = form_cholesky.cleaned_data
            m = create_matrix(ast.literal_eval(data["matrix"]))
            b = create_vector(ast.literal_eval(data["b"]))
            res = cholesky_method.cholesky_factorization(m,b)
            return render(request,"metodos/cholesky.html",{"form":form_cholesky,"res":res})

    form_cholesky = formAB()
    return render(request, "metodos/cholesky.html",{"form":form_cholesky})

def seidel(request):
    if request.method == "POST":
        form_seidel = formITER(request.POST)
        if form_seidel.is_valid():
            data = form_seidel.cleaned_data
            m = create_matrix(ast.literal_eval(data["matrix"]))
            b = create_vector(ast.literal_eval(data["b"]))
            init = create_vector(ast.literal_eval(data["init"]))
            tol = float(data["tol"])
            n = int(data["n"])
            res,table = seidel_method.seidel(m,b,init,tol,n)
            return render(request,"metodos/seidel.html",{"form":form_seidel,"res":res,"table":table})

    form_seidel = formITER()
    return render(request, "metodos/seidel.html",{"form":form_seidel})

def jacobi(request):
    if request.method == "POST":
        form_jacobi = formITER(request.POST)
        if form_jacobi.is_valid():
            data = form_jacobi.cleaned_data
            m = create_matrix(ast.literal_eval(data["matrix"]))
            b = create_vector(ast.literal_eval(data["b"]))
            init = create_vector(ast.literal_eval(data["init"]))
            tol = float(data["tol"])
            n = int(data["n"])
            res,table = jacobi_method.jacobi(m,b,init,tol,n)
            return render(request,"metodos/jacobi.html",{"form":form_jacobi,"res":res,"table":table})

    form_jacobi = formITER()
    return render(request, "metodos/jacobi.html",{"form":form_jacobi})

def diferencias_divididas(request):
    if request.method == "POST":
        form_dif = formPoints(request.POST)
        if form_dif.is_valid():
            data = form_dif.cleaned_data
            p = data["points"]
            points = list(ast.literal_eval(p))
            res = newton_interpolation.divided_differences(points)
            return render(request,"metodos/diferenciasDivididas.html",{"form":form_dif,"tabla":res["tabla"],"pol":res["pol"],"spol":res["spol"]})

    form_dif = formPoints()
    return render(request, "metodos/diferenciasDivididas.html",{"form":form_dif})

def splines(request):
    if request.method == "POST":
        form_splines = formPoints(request.POST)
        if form_splines.is_valid():
            data = form_splines.cleaned_data
            p = data["points"]
            points = list(ast.literal_eval(p))
            linear = splines_method.linear_splines(points)
            quad = splines_method.quadratic_splines(points)
            return render(request,"metodos/splines.html",{"form":form_splines,"res":{"linear":linear,"quad":quad}})

    form_splines = formPoints()
    return render(request, "metodos/splines.html",{"form":form_splines})

def lagrange(request):
    if request.method == "POST":
        form_lagrange = formPoints(request.POST)
        if form_lagrange.is_valid():
            data = form_lagrange.cleaned_data
            p = data["points"]
            points = list(ast.literal_eval(p))
            res = lagrange_interpolation.lagrange(points)
            return render(request,"metodos/lagrange.html",{"form":form_lagrange,"res":res})

    form_lagrange = formPoints()
    return render(request, "metodos/lagrange.html",{"form":form_lagrange})