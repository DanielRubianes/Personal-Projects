# NOTE: ChatGPT wrote the majority of this code
def dissolve_points(input_dict):
    dissolved_dict = {}
    visited_points = set()

    def find_nearby_points(station):
        nearby_points = [key for key, value in input_dict.items() if abs(value["Station"] - station) <= 1]
        return nearby_points

    for point in input_dict:
        if point not in visited_points:
            dissolved_group = set()
            stack = [point]

            while stack:
                current_point = stack.pop()
                if current_point not in visited_points:
                    visited_points.add(current_point)
                    dissolved_group.add(current_point)
                    nearby_points = find_nearby_points(input_dict[current_point]["Station"])
                    stack.extend(nearby_points)

            if dissolved_group:
                average_station = sum(input_dict[p]["Station"] for p in dissolved_group) / len(dissolved_group)
                dissolved_dict[min(dissolved_group)] = {"Station": average_station}

    return dissolved_dict

dissolveTolorance = 2

def dissolvePoints(inputDict):
    dissolvedDict = {}
    visitedPoints = set()

    for point in input_dict:
        if point in visitedPoints: continue
        station = point["Station"]
        nearPoints = [key for key, nearPoint in inputDict.items() if abs(nearPoint["Station"] - station) <= dissolveTolorance]
        visitedPoints.update(nearPoints)
        



# Example usage with the provided dictionary
input_dict = {
    1: {"Station": 1},
    2: {"Station": 2},
    3: {"Station": 3},
    4: {"Station": 4},
    5: {"Station": 5},
    6: {"Station": 6},
    7: {"Station": 10},
    8: {"Station": 11},
    9: {"Station": 12}
}

result = dissolve_points(input_dict)
print(result)