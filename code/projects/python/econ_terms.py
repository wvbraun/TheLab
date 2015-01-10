import textwrap

short_line = "-----------------------\n"


def budget():
    print("\nBudget Line Stuff: ")
    print(short_line)

    budget.terms = {
            "slope of budget line" : "-Px/Py",
            "budget constraint" : "Px(x) + Py(y) = m",
            "y-int" : "m/Py",
            "x-int" : "m/Px",
            "an increase in income (m) does what to the budget constraint" : \
            "the budget constraint shifts right, the slope does not change",
            "an increase in the price of good x (Px) does what to the budget constraint" : \
            "the x-int shifts right, the size of the budget shrinks, a loss of purchasing power",
            "an increase in the price of good y (Py) does what to the budget constraint":\
            "the y-int shifts right",
            "what is the budget set" : "all bundles that are affordable at the given prices and income"
        }

def preferences():
    
    print("\nPreferernces: ")
    print(short_line)

    preferences.terms = {
        "first axiom of consumer preferences" : \
        "complete- any two bundles can be compared",
        "second axiom of consumer preferences" : \
        "reflexive- any bundle is at least as good as itself",
        "third axiom of consumer preferences": \
        "transitive - if (x1,x2) is strongly prefered to (y1,y2) and (y1, y2) is strongly \
        preferred to (z1,z2), then (x1,x2) is strongly preferred to (z1,z2)",
        "why can indifference curves not cross?" : \
        "if they did, x y and z would all be indifferent to eachother",
        "what is important about the slope of the indifference curves with \
        perfect substitutes" : \
        "they have a constant slope",
        "what is imporant about perfect compliments": \
        "the consumer prefers to consume the goods in fixed proportions", 
        "what are perfect compliments" : \
        "goods that are always consumed together in fixed proportions",
        "what are bads" : \
        "a commodity that the consumer does not like", 
        "what is a neutral good" : \
        "a good the consumer does not care about",
        "what will the indifference curves look like for netural goods, why?" : \
        "vertical lines, the consumer only cares about 1 of the goods",
        "satiation point" : "bliss point",
        "what is a discrete good" : \
        "a good that is only available in integer amounts",
        "what is monoticity" : "assumption that more is preffered to less.",
        "why are well-behaved preferences convex" : "because most goods are consumed together",
        "what is the marginal rate of substitution" : \
        "the rate at which the consumer is willing to substitute a marginal amount of good 1 for a \
        a marginal amount of good 2",
        "the slope of the indifference curve" : "the marginal rate of substitution",
        "another definitions for MRS" : "marginal willingness to pay",
        "what is the mrs of perfect substitutes" : "constant -1",
        "what is the mrs of nuetrals" : "everywhere infinite",
        "what is the mrs of perfect compliments" : "either zero or infinity",
        "well behaved preference curves are" : "monotonic and convex"
        }

def utility():
    print("\nUtility: ")
    print(short_line)

    utility.terms = {
        "cobbs-douglas utility function" : "u(x,y) = xy",
        "setting utility equal to some arbitrary constant c for indifference curves gives what formula" : \
        "y = c/x",
        "the problem of a household can be stated as" : "max u(x,y); subject to Px(X) + Py(Y) = m",
        "how do you solve the problem of a household, max u(x,y); s.t. Px(X) + Py(Y) = m" : \
        "plug in ((m/px) - (Px/Py)X) for y. take the derivative of the new function",
        "u1/u2 =" : "Px/Py",
        "u1/u2 is what" : "the slope of the indifference curves",
        "if u1/u2 > Px/Py, what does this tell us" : \
        "the consumer consumes very little good x compared to good y and that the marginal utility is large for x, small for y",
        "what is the last dollar rule" : "u1/u2 = Px/Py <=> u1/Px = u2/Py",
        "what is u1/Px" : "the marginal utility from spending the last dollar on good x",
        "what is u2/Py" : "the marginal utility from spending the last dollar on good y",
        "if u1/Px > u2/Py, what does this tell us" : "the marginal utility from spending the last dollar on good x is greater than on y",
        "in general, demand for good x will depand on what" : "m, Px, and Py", 
        "what is the formula for the price elasticity of demand for good x" : \
        "(delta x)/(delta Px) * Px/x",
        "what is the formula for the cross elasticity of demand for good x" : \
        "(delta y)/(delta Py) * Py/y",
        "what is the forumal for the income elasticity of demand for good x" : \
        "(delta x)/(delta m) * m/x",
        "in order to solve the utility maximization problem, the househould needs to choose what" : \
        "a consumption bundle where the indifference curves are exactly tangent to the budget line",
        }
def sub():
    print("\nIncome and Substitution Effect: ")
    print(short_line)

    sub.terms = {
        "a decrease in income does what to a normal good" : \
        "causes a decline in the consumption of that good",
        "an increase in income does what to a normal good" : \
        "causes an increase in the consumption of that good",
        "a decrease in income does what to an inferior good" : \
        "causes an increase in the consumption of that good", 
        "an increase in income does what to an inferior good" : \
        "causes a decrease in consumption of that good",
        "when the income and substitution effect work in the same direction" : \
        "demand is downward sloping",
        "when the substitution effect > income effect, and they are in opposite directions" : \
        "demand is downward sloping",
        "when the income effect > substitution effect, and they are in opposite directions" : \
        "demand is upward sloping"
        }


def taxes():
    print("\nTaxes and Susbidies: ")
    print(short_line)


    taxes.terms = {
        "quantity tax" : "the consumer has to pay a certain amount to the government for each purchase",
        "value tax" : "a tax on the value of a good",
        "value taxes are also known as" : "ad valorem taxes",
        "quantity subsidy" : "the government gives an amount to the consumer that depends on the amount purchashed",
        "lump sum tax" : "the government takes away some fixed amount of money",
        "what does a lump sum tax do to the budget line" : "causes it to shift inward since income has been reduced",
        "what does a quantity tax do to the budget line" : "causes it become steeper since theres a higher price for a good",
        "what does a lump sum subsidy do to the budget line" : "causes it to shift outward",
        "rationing constraint" : "level of consumption of some good is fixed to be no larger than some amount"
         }

def obama():
    print("\nThe Affordable Care Act")
    print(short_line)

    obama.terms = {
        "what is an important component of the aca" : "health insurance vouchers are made available to all households", 
        "what do flat indifference curves mean with health insurance" : "the cost of buying health insurance is too large, thus \
the consumer does not buy health insurance",
        "what are the 2 type of consumers that do not purchase health insurance" : "those that cannot afford it and those \
that can afford it but do not want it"
         }
