#include <iostream>
#include <fstream>
#include <random>
#include <string>
#include <thread>
#include <chrono>
#include <filesystem>
#include <map>
#include <nlohmann/json.hpp>

using json = nlohmann::json;
namespace fs = std::filesystem;

// Program Constants, change to change the program behavior
const std::string OUTPUT_DIR = "queue";
const int NR_OF_GENERATIONS = 30;
const int MIN_WAIT = 500;  // in ms
const int MAX_WAIT = 3000; // in ms
const double SECOND = 1000.0;

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
    // some cleaning
    if (fs::exists(OUTPUT_DIR)) {
        fs::remove_all(OUTPUT_DIR);
    }
    fs::create_directory(OUTPUT_DIR);

    // Random number generators
    std::random_device rd;
    std::mt19937 gen(rd());

    // wow
    std::uniform_int_distribution<> car_type_dist(0, CAR_TYPES.size() - 1);
    std::uniform_int_distribution<> passenger_type_dist(0, PASSENGER_TYPES.size() - 1);
    std::uniform_int_distribution<> is_dining_dist(0, IS_DINING.size() - 1);
    std::uniform_int_distribution<> consumption_dist(CONSUMPTION_RANGE.first, CONSUMPTION_RANGE.second);
    std::uniform_int_distribution<> wait_dist(MIN_WAIT, MAX_WAIT);

    for (int i = 1; i <= NR_OF_GENERATIONS; ++i) {
        std::string cartype = CAR_TYPES[car_type_dist(gen)];
        std::string passengers = PASSENGER_TYPES[passenger_type_dist(gen)];
        bool isDining = IS_DINING[is_dining_dist(gen)];
        int consumption = consumption_dist(gen);

        // Update stats
        STATS[cartype]++;
        STATS[passengers]++;
        if (isDining) {
            STATS["DINING"]++;
        } else {
            STATS["NOT_DINING"]++;
        }
        CONSUMPTION[cartype] += consumption;

        // Create car JSON object
        json car = {
            {"id", i},
            {"type", cartype},
            {"passengers", passengers},
            {"isDining", isDining},
            {"consumption", consumption}
        };

        // Write JSON to file
        std::string file_path = OUTPUT_DIR + "/Car" + std::to_string(i) + ".json";
        std::ofstream file(file_path);

        file << car.dump(4);
        file.close();

        // Print workflow
        std::cout << car.dump() << std::endl;

        // Wait for a random interval between 500-3000 milliseconds
        std::this_thread::sleep_for(std::chrono::milliseconds(wait_dist(gen)));
    }

    // Print summary statistics
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
