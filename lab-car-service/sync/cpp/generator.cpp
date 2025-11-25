#include <iostream>
#include <fstream>
#include <random>
#include <string>
#include <filesystem>
#include <map>
#include <nlohmann/json.hpp>

using json = nlohmann::json;
namespace fs = std::filesystem;

// Constants
const int NR_OF_GENERATIONS = 30;

// Car properties
const std::vector<std::string> CAR_TYPES = {"ELECTRIC", "GAS"};
const std::vector<std::string> PASSENGER_TYPES = {"PEOPLE", "ROBOTS"};
const std::vector<bool> IS_DINING = {true, false};
const std::pair<int, int> CONSUMPTION_RANGE = {10, 50};

// Statistics
std::map<std::string, int> STATS = {
    {"ELECTRIC", 0},
    {"GAS", 0},
    {"PEOPLE", 0},
    {"ROBOTS", 0},
    {"DINING", 0},
    {"NOT_DINING", 0}
};

std::map<std::string, int> CONSUMPTION = {
    {"ELECTRIC", 0},
    {"GAS", 0}
};

int main() {
    // Random number generators
    std::random_device rd;
    std::mt19937 gen(rd());

    std::uniform_int_distribution<> car_type_dist(0, CAR_TYPES.size() - 1);
    std::uniform_int_distribution<> passenger_type_dist(0, PASSENGER_TYPES.size() - 1);
    std::uniform_int_distribution<> is_dining_dist(0, IS_DINING.size() - 1);
    std::uniform_int_distribution<> consumption_dist(CONSUMPTION_RANGE.first, CONSUMPTION_RANGE.second);

    json all_cars = json::array();

    for (int i = 1; i <= NR_OF_GENERATIONS; ++i) {
        std::string cartype = CAR_TYPES[car_type_dist(gen)];
        std::string passengers = PASSENGER_TYPES[passenger_type_dist(gen)];
        bool isDining = IS_DINING[is_dining_dist(gen)];
        int consumption = consumption_dist(gen);

        // Update stats
        STATS[cartype]++;
        STATS[passengers]++;
        STATS[isDining ? "DINING" : "NOT_DINING"]++;
        CONSUMPTION[cartype] += consumption;

        // Create car JSON object
        json car = {
            {"id", i},
            {"type", cartype},
            {"passengers", passengers},
            {"isDining", isDining},
            {"consumption", consumption}
        };

        all_cars.push_back(car);
    }

    // Write the entire array to a single file
    std::ofstream outFile("cars.json");
    outFile << all_cars.dump(4);
    outFile.close();

    // Optional: print summary
    json stats = {
        {"ELECTRIC", STATS["ELECTRIC"]},
        {"GAS", STATS["GAS"]},
        {"PEOPLE", STATS["PEOPLE"]},
        {"ROBOTS", STATS["ROBOTS"]},
        {"DINING", STATS["DINING"]},
        {"NOT_DINING", STATS["NOT_DINING"]},
        {"CONSUMPTION", {
            {"ELECTRIC", CONSUMPTION["ELECTRIC"]},
            {"GAS", CONSUMPTION["GAS"]}
        }}
    };

    std::cout << stats.dump(4) << std::endl;

    return 0;
}
