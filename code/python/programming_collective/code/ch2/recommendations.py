# A dictionary of movie critics and their rating of 
# a small set of movies

critics = {
		'Lisa Rose': {'Lady in the Water' : 2.5,
			'Snakes on a Plane': 3.5, 'Just My Luck': 3.0,
			'Superman Returns':5.0,
			'You, Me and Dupree':2.5, 
			'The Night Listener': 3.0},
		'Gene Seymour': {'Lady in the Water': 3.0,
			'Snakes on a Plane': 3.5, 'Just My Luck':1.5,
			'Superman Returns': 5.0, 
			'You, Me and Dupree': 3.5,
			'The Night Listener':3.0},
		'Michael Phillips': {'Lady in the Water':2.5,
			'Snakes on a Plane':3.5,
			'Superman Returns': 3.5,
			'The Night Listener':4.0},
		'Claudia Puig': {'Snakes on a Plane': 3.5,
			'Just My Luck': 3.0,
			'The Night Listener':4.5,
			'Superman Returns':4.0,
			'You, Me and Dupree': 2.5},
		'Mick LaSalle': {'Lady in the Water': 3.0, 
			'Snakes on a Plane':4.0,
			'Just My Luck':2.0,
			'Superman Returns':3.0,
			'The Night Listener':3.0,
			'You, Me and Dupree':2.0},
		'Jack Matthews': {'Lady in the Water': 3.0,
			'Snakes on a Plane': 4.0,
			'The Night Listener':3.0,
			'Superman Returns': 5.0, 
			'You, Me and Dupree':3.5},
		'Toby' : {'Snakes on a Plane': 4.5, 
			'You, Me and Dupree': 1.0,
			'Superman Returns':4.0} }


from math import sqrt

# returns a distance-based similarity score for person1 and preson2

def sim_distance(prefs, person1, person2):
    #get the list of shared items

    si = {}
    for item in prefs[person1]:
        if item in prefs[person2]:
            si[item]=1

    #if they have no ratings in common, return 0
    if len(si)==0:
        return 0

    # add up all the squares of all the differences

    sum_of_squares= sum([pow(prefs[person1][item]-prefs[person2][item],2)
                        for item in prefs[person1] if item in prefs[person2]])

    return 1/(1 + sum_of_squares)

# returns Pearson correlation coefficient for p1 and p2

def sim_pearson(prefs, p1,p2):

    #get the list of mutually related items

    si={}
    for item in prefs[p1]:
        if item in prefs[p2]: si[item]= 1


    # find the number of elements
    n = len(si)

    # if there are no ratings in common, return 0
    if n==0:
        return 0

    # addd up all the preferences
    sum1 = sum([prefs[p1][it] for it in si])
    sum2 = sum([prefs[p2][it] for it in si])

    # sum up the squares
    sum1sq = sum([pow(prefs[p1][it], 2) for it in si])
    sum2sq = sum([pow(prefs[p2][it], 2) for it in si])

    # sum the products
    pSum = sum([prefs[p1][it] * prefs[p2][it] for it in si])

    # calc pearson score 
    num = pSum - (sum1 * sum2 / n)
    denom = sqrt((sum1sq - pow(sum1,2)/n) * (sum2sq-pow(sum2,2)/n))
    
    if denom == 0:
        return 0

    r = num / denom 

    return r 

# returns the best matches for person from the prefs dictionary
# number of results and similarity function are optional params

def topMatches(prefs, person, n=5, similarity = sim_pearson):
    scores = [(similarity(prefs, person, other), other)
            for other in prefs if other !=person]

    #sort list so the highest score appears at top

    scores.sort()
    scores.reverse()
    return scores[0:n]

# gets recommendations for a person by using a weighted avg.
# of every other users rankings

def getRecommendations(prefs, person, similarity=sim_pearson):

    totals = {}
    simSums = {}
    for other in prefs:
        # do not compare oneself
        if other == person: 
            continue 
        sim = similarity(prefs, person, other)

        # ignore scores of 0 or lower
        if sim <= 0:
            continue

        for item in prefs[other]:

            # only score movies i havent seen yet
            if item not in prefs[person] or prefs[person][item]==0:

                #sim * score
                totals.setdefault(item,0)
                totals[item]+=prefs[other][item]*sim

                # sum of sims
                simSums.setdefault(item,0)
                simSums[item]+=sim

        # create the normalized list

        rankings = [(total/simSums[item],item) for item, total in totals.items()]

        # return the sorted list
        rankings.sort()
        rankings.reverse()
        return rankings

def transformPrefs(prefs):
    result = {}
    for person in prefs:
        for item in prefs[person]:
            result.setdefault(item,{})

            # flip item and person
            result[item][person] = prefs[person][item]
    return result
def calculateSimilarItems(prefs, n=10):
    #create a dict of items showing which other items they 
    # are most similar to.
    result = {}

    #invert the preferences matrix to be item-centric
    itemPrefs = transformPrefs(prefs)
    c = 0
    for item in itemPrefs:
        #status updates for large datasets
        c+=1
        if c%100==0:
            print "%d / %d" % (c, len(itemPrefs))

        #find most similar items to this one
        scores = topMatches(itemPrefs, item, n = n,similarity= sim_distance)
        result[item]=scores
    return result


def getRecommendedItems(prefs, itemMatch, user):
    userRatings=prefs[user]
    scores={}
    totalSim={}

    #loop over items rated by this user
    for (item, rating) in userRatings.items():

        #loop over items similar to this one
        for (similarity, item2) in itemMatch[item]:

            #ignore if this user has already rated this item
            if item2 in userRatings:
                continue 

            #weighted sum of rating times similarity
            scores.setdefault(item2,0)
            scores[item2]+=similiarty*rating

            #sum of all the similiarities
            totalSim.setdefault(item2,0)
            totalSim[item2]+=similarity

    # divide each total score by total weighting to get an avg. 
    rankings = [(score/totalSim[item],item) for item, score in scores.items()]

    #return the rankings from highest to lowest
    rankings.sort()
    rankings.reverse()
    return rankings
