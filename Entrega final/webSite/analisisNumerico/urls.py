"""analisisNumerico URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/4.0/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path
from contenido import views as cont_views

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', cont_views.home, name="Home"),
    path('bisection/', cont_views.bisection, name="Bisection"),
    path('fixed/', cont_views.fixed_point, name="Fixed"),
    path('incremental/', cont_views.incremental_search, name="Incremental"),
    path('false/', cont_views.false_rule, name="False"),
    path('newton/', cont_views.newton, name="Newton"),
    path('secant/', cont_views.secant, name="Secant"),
    path('roots/', cont_views.multiple_roots, name="Roots"),
    path('prog/', cont_views.progressive_substitution, name="Progressive"),
    path('reg/', cont_views.regressive_substitution, name="Regressive"),
    path('gauss/', cont_views.gauss, name="Gauss"),
    path('partial/', cont_views.partial_pivot, name="Partial"),
    path('total/', cont_views.total_pivot, name="Total"),
    path('gaussP/', cont_views.gauss_partial_pivot, name="GaussPartial"),
    path('gaussT/', cont_views.gauss_total_pivot, name="GaussTotal"),
    path('luGauss/', cont_views.lu_gauss, name="LuGauss"),
    path('crout/', cont_views.crout, name="Crout"),
    path('doolittle/', cont_views.doolittle, name="Doolittle"),
    path('cholesky/', cont_views.cholesky, name="Cholesky"),
    path('seidel/', cont_views.seidel, name="Seidel"),
    path('jacobi/', cont_views.jacobi, name="Jacobi"),
    path('dif/', cont_views.diferencias_divididas, name="Diferencias"),
    path('splines/', cont_views.splines, name="Splines"),
    path('lagrange/', cont_views.lagrange, name="Lagrange"),
]
