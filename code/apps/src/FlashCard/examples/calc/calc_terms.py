import random

short_line = "---------------------------\n"

def trig_ident():
    print("Trigonometric Identities: ")
    print(short_line)

    trig_ident.terms = {
        "sin^2(x)" : "1 - cos^2(x); (1/2)(1 - cos(2x))",
        "cos^2(x)" : "1 - sin^2(x); (1/2)(1 + cos(2x))", 
        "tan^2(x)" : "sec^2(x) - 1; (1 - cos(2x)) / (1 + cos(2x))",
        "sec^2(x)" : "tan^2(x) + 1", 
        "sin(2x)" : "2sin(x)cos(x)", 
        "cos(2x)" : "cos^2(x) - sin^2(x) = 2cos^2(x) - 1 = 1 - 2sin^2(x)",
        "tan(2x)" : "(2tan(x)) / (1 - tan^2(x))",
        "sin(a+b)" : "sin(a)cos(b) + sin(b)cos(a)", 
        "sin(a-b)" : "sin(a)cos(b) - sin(b)cos(a)",
        "cos(a+b)" : "cos(a)cos(b) - sin(a)sin(b)",
        "cos(a-b)" : "cos(a)cos(b) + sin(a)sin(b)", 
        "sin(0.5x)" : "(1/2)cos(x)sin(x)",
        "law of sines" : "sin(A)/a = sin(B)/b = sin(C)/c",
        "law of cosines" : "c^2 = a^2 + b^2 + 2abcos(c)",
        "sin(pi/3)" : "sqrt(3)/2",
        "cos(pi/3)" : "1/2",
        "tan(pi/3)" : "sqrt(3)",
        "sin(pi/6)" : "1/2",
        "cos(pi/6)" : "sqrt(3)/2", 
        "tan(pi/6)" : "1/sqrt(3)"
    }

def trig_integral():
    print("Trigonometric Integration: ")
    print(short_line)

    trig_integral.terms = {
        "integral of sin^m(x)cos^n(x)dx; m and n are positive integers \
        and at least 1 of n or m is odd." : \
        "save odd factor, use sin^2(x) + cos^2(x) = 1", 
        "integral of sin^m(x)cos^n(x)dx; m and n are positive, even integers" : \
        "use cos^2(x) = (1/2)(1 + cos(2x)) or sin^2(x) = (1/2)(1 - cos(2x)) or sin(2x) = 2sin(x)cos(x)",
        "integral of tan(x)dx" : "ln(secx) + c",
        "integral of sec(x)dx" : "ln(secx + tanx) + c", 
        "integral of tan^n(x)sec^m(x); m and n are postive, even integers" : \
        "let u = tanx, use sec^2(x) = 1 + tan^2(x)", 
        "integral of tan^n(x)sec^m(x)dx; m,n positive, 1 or more odd" : \
        "let u = secx, save tan(x)sec(x)",
        "integral of sin(mx)cos(nx)dx" : "(1/2)[sin(m-n) + sin(m+n)]",
        "integral of sin(mx)sin(nx)dx" : "(1/2)[cos(m-n) - cos(m+n)]",
        "integral of cos(mx)cos(nx)dx" : "(1/2)[cos(m-n) + cos(m+n)]"
        }

def integration():
    print("Integration: ")
    print(short_line)

    integration.terms = {
        "integration by parts formula" : "uv - integral of vdu",
        "integral of sec^2(x)dx" : "tanx",
        "integral of sec(x)tan(x)dx" : "secx",
        "integral of tanxdx" : "ln(secx)",
        "integral of 1/(x^2 + a^2)" : "(1/a)arctan(x/a)",
        "integral of a^x" : "a^x/ln(a)",
        "integral of csc^2(x)" : "-cotx",
        "integral of csc(x)cot(x)dx" : "-cscx",
        "integral of cotx" : "ln(sinx)"
    }

def reduction():
    print("Reduction Formula: ")
    print(short_line)
    
    reduction.terms = {
        "sin^n(x)dx" : "(sin^n-1(x)cosx/n) + ((n-1)/n)*integral of sin^n-2(x)dx",
        "cos^n(x)dx" : "(cos^n-1(x)sinx/n) + ((n-1)/n)*integral of cos^n-2(x)dx",
        "tan^n(x)dx" : "(tan^n-1(x)/(n-1)) - integral of tan^n-2(x)dx",
        "(x^n)sinxdx" : "-x^ncosx - n*integral of x^n-1cosxdx",
        "(x^n)cosxdx" : "x^nsinx - n*integral of x^n-1sinxdx",
        "(x^n)*e^(ax)dx" : "(1/a)(x^n)e^(ax) - (n/a)*integral of (x^n-1)e^(ax)dx",
        "sec^n(x)dx" : "tan(x)sec^n-2(x)/(n-1) + (n-2)/(n-1)*integral of sec^n-2(x)dx",
        "sin^n(x)cos^m(x)dx" : "sin^n+1(x)cos^m-1(x) + (m-1)/(n+m)*integral of sin^n(x)cos^m-2(x)dx"
    }


