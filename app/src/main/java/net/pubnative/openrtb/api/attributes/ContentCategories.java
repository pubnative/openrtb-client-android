package net.pubnative.openrtb.api.attributes;

import java.util.HashMap;
import java.util.Map;

public final class ContentCategories {
    private static final Map<String, Map<String, String>> sCategories;

    static {
        Map<String, String> iab1 = new HashMap<>(7);
        Map<String, String> iab2 = new HashMap<>(23);
        Map<String, String> iab3 = new HashMap<>(12);
        Map<String, String> iab4 = new HashMap<>(11);
        Map<String, String> iab5 = new HashMap<>(15);
        Map<String, String> iab6 = new HashMap<>(9);
        Map<String, String> iab7 = new HashMap<>(45);
        Map<String, String> iab8 = new HashMap<>(18);
        Map<String, String> iab9 = new HashMap<>(31);
        Map<String, String> iab10 = new HashMap<>(9);
        Map<String, String> iab11 = new HashMap<>(5);
        Map<String, String> iab12 = new HashMap<>(3);
        Map<String, String> iab13 = new HashMap<>(12);
        Map<String, String> iab14 = new HashMap<>(8);
        Map<String, String> iab15 = new HashMap<>(10);
        Map<String, String> iab16 = new HashMap<>(7);
        Map<String, String> iab17 = new HashMap<>(44);
        Map<String, String> iab18 = new HashMap<>(6);
        Map<String, String> iab19 = new HashMap<>(36);
        Map<String, String> iab20 = new HashMap<>(27);
        Map<String, String> iab21 = new HashMap<>(3);
        Map<String, String> iab22 = new HashMap<>(4);
        Map<String, String> iab23 = new HashMap<>(10);
        Map<String, String> iab24 = new HashMap<>(0);
        Map<String, String> iab25 = new HashMap<>(7);
        Map<String, String> iab26 = new HashMap<>(4);

        sCategories = new HashMap<>(26);
        sCategories.put("IAB1", iab1);
        sCategories.put("IAB2", iab2);
        sCategories.put("IAB3", iab3);
        sCategories.put("IAB4", iab4);
        sCategories.put("IAB5", iab5);
        sCategories.put("IAB6", iab6);
        sCategories.put("IAB7", iab7);
        sCategories.put("IAB8", iab8);
        sCategories.put("IAB9", iab9);
        sCategories.put("IAB10", iab10);
        sCategories.put("IAB11", iab11);
        sCategories.put("IAB12", iab12);
        sCategories.put("IAB13", iab13);
        sCategories.put("IAB14", iab14);
        sCategories.put("IAB15", iab15);
        sCategories.put("IAB16", iab16);
        sCategories.put("IAB17", iab17);
        sCategories.put("IAB18", iab18);
        sCategories.put("IAB19", iab19);
        sCategories.put("IAB20", iab20);
        sCategories.put("IAB21", iab21);
        sCategories.put("IAB22", iab22);
        sCategories.put("IAB23", iab23);
        sCategories.put("IAB24", iab24);
        sCategories.put("IAB25", iab25);
        sCategories.put("IAB26", iab26);
    }

    public static final class ArtsEntertainment {
        public static final String CATEGORY_CODE = "IAB1";

        public static final String BOOKS_LITERATURE = "IAB1-1";
        public static final String CELEBRITY_FAN_GOSSIP = "IAB1-2";
        public static final String FINE_ART = "IAB1-3";
        public static final String HUMOR = "IAB1-4";
        public static final String MOVIES = "IAB1-5";
        public static final String MUSIC = "IAB1-6";
        public static final String TELEVISION = "IAB1-7";
    }

    public static final class Automotive {
        public static final String CATEGORY_CODE = "IAB2";

        public static final String AUTO_PARTS = "IAB2-1";
        public static final String AUTO_REPAIR = "IAB2-2";
        public static final String BYING_SELLING_CARS = "IAB2-3";
        public static final String CAR_CULTURE = "IAB2-4";
        public static final String CERTIFIED_PRE_OWNED = "IAB2-5";
        public static final String CONVERTIBLE = "IAB2-6";
        public static final String COUPE = "IAB2-7";
        public static final String CROSSOVER = "IAB2-8";
        public static final String DIESEL = "IAB2-9";
        public static final String ELECTRIC_VEHICLE = "IAB2-10";
        public static final String HATCHBACK = "IAB2-11";
        public static final String HYBRID = "IAB2-12";
        public static final String LUXURY = "IAB2-13";
        public static final String MINIVAN = "IAB2-14";
        public static final String MOTORCYCLES = "IAB2-15";
        public static final String OFF_ROAD_VEHICLES = "IAB2-16";
        public static final String PERFORMANCE_VEHICLES = "IAB2-17";
        public static final String PICKUP = "IAB2-18";
        public static final String ROAD_SIDE_ASSISTANCE = "IAB2-19";
        public static final String SEDAN = "IAB2-20";
        public static final String TRUCKS_AND_ACCESSORIES = "IAB2-21";
        public static final String VINTAGE_CARS = "IAB2-22";
        public static final String WAGON = "IAB2-23";
    }

    public static final class Business {
        public static final String CATEGORY_CODE = "IAB3";

        public static final String ADVERTISING = "IAB3-1";
        public static final String AGRICULTURE = "IAB3-2";
        public static final String BIOTECH_BIOMEDICAL = "IAB3-3";
        public static final String BUSINESS_SOFTWARE = "IAB3-4";
        public static final String CONSTRUCTION = "IAB3-5";
        public static final String FORESTRY = "IAB3-6";
        public static final String GOVERNMENT = "IAB3-7";
        public static final String GREEN_SOLUTIONS = "IAB3-8";
        public static final String HUMAN_RESOURCES = "IAB3-9";
        public static final String LOGISTICS = "IAB3-10";
        public static final String MARKETING = "IAB3-11";
        public static final String METALS = "IAB3-12";
    }

    public static final class Careers {
        public static final String CATEGORY_CODE = "IAB4";

        public static final String CAREER_PLANNING = "IAB4-1";
        public static final String COLLEGE = "IAB4-2";
        public static final String FINANCIAL_AID = "IAB4-3";
        public static final String JOB_FAIRS = "IAB4-4";
        public static final String JOB_SEARCH = "IAB4-5";
        public static final String RESUME_WRITTING_ADVISE = "IAB4-6";
        public static final String NURSING = "IAB4-7";
        public static final String SCHOLARSHIPS = "IAB4-8";
        public static final String TELECOMMUTING = "IAB4-9";
        public static final String US_MILITARY = "IAB4-10";
        public static final String CAREER_ADVICE = "IAB4-11";
    }

    public static final class Education {
        public static final String CATEGORY_CODE = "IAB5";

        public static final String EDUCATION_7_TO_12 = "IAB5-1";
        public static final String ADULT_EDUCATION = "IAB5-2";
        public static final String ART_HISTORY = "IAB5-3";
        public static final String COLLEGE_ADMINISTRATION = "IAB5-4";
        public static final String COLLEGE_LIFE = "IAB5-5";
        public static final String DISTANCE_LEARNING = "IAB5-6";
        public static final String ENGLISH_AS_2ND_LANGUAGE = "IAB5-7";
        public static final String LANGUAGE_LEARNING = "IAB5-8";
        public static final String GRADUATE_SCHOOL = "IAB5-9";
        public static final String HOMESCHOOLING = "IAB5-10";
        public static final String HOMEWORK_STUDY_TIPS = "IAB5-11";
        public static final String K_6_EDUCATORS = "IAB5-12";
        public static final String PRIVATE_SCHOOL = "IAB5-13";
        public static final String SPECIAL_EDUCATION = "IAB5-14";
        public static final String STUDYING_BUSINESS = "IAB5-15";
    }

    public static final class FamilyAndParenting {
        public static final String CATEGORY_CODE = "IAB6";

        public static final String ADOPTION = "IAB6-1";
        public static final String BABIES_TODDLERS = "IAB6-2";
        public static final String DAYCARE_PRE_SCHOOL = "IAB6-3";
        public static final String FAMILY_INTERNET = "IAB6-4";
        public static final String PARENTING_K_6_KIDS = "IAB6-5";
        public static final String PARENTING_TEENS = "IAB6-6";
        public static final String PREGNANCY = "IAB6-7";
        public static final String SPECIAL_NEEDS_KIDS = "IAB6-8";
        public static final String ELDERCARE = "IAB6-9";
    }

    public static final class HealthAndFitness {
        public static final String CATEGORY_CODE = "IAB7";

        public static final String EXCERCISE = "IAB7-1";
        public static final String ADD = "IAB7-2";
        public static final String AIDS_HIV = "IAB7-3";
        public static final String ALLERGIES = "IAB7-4";
        public static final String ALTERNATIVE_MEDICINE = "IAB7-5";
        public static final String ARTHRITIS = "IAB7-6";
        public static final String ASTHMA = "IAB7-7";
        public static final String AUTISM_PDD = "IAB7-8";
        public static final String BIPOLAR_DISORDER = "IAB7-9";
        public static final String BRAIN_TUMOR = "IAB7-10";
        public static final String CANCER = "IAB7-11";
        public static final String CHOLESTEROL = "IAB7-12";
        public static final String CHRONIC_FATIGUE_SYNDROME = "IAB7-13";
        public static final String CHRONIC_PAIN = "IAB7-14";
        public static final String COLD_AND_FLU = "IAB7-15";
        public static final String DEAFNESS = "IAB7-16";
        public static final String DENTAL_CARE = "IAB7-17";
        public static final String DEPRESSION = "IAB7-18";
        public static final String DERMATOLOGY = "IAB7-19";
        public static final String DIABETES = "IAB7-20";
        public static final String EPILEPSY = "IAB7-21";
        public static final String GERD_ACID_REFLUX = "IAB7-22";
        public static final String HEADACHES_MIGRAINES = "IAB7-23";
        public static final String HEART_DISEASE = "IAB7-24";
        public static final String HERBS_FOR_HEALTH = "IAB7-25";
        public static final String HOLISTIC_HEALING = "IAB7-26";
        public static final String IBS_CROHNS_DISEASE = "IAB7-27";
        public static final String INCEST_ABUSE_SUPPORT = "IAB7-28";
        public static final String INCONTINCENCE = "IAB7-29";
        public static final String INFERTILITY = "IAB7-30";
        public static final String MENS_HEALTH = "IAB7-31";
        public static final String NUTRITION = "IAB7-32";
        public static final String ORTHOPEDICS = "IAB7-33";
        public static final String PANIC_ANXIETY_DISORDERS = "IAB7-34";
        public static final String PEDIATRICS = "IAB7-35";
        public static final String PHYSICAL_THERAPY = "IAB7-36";
        public static final String PSYCHOLOGY_PSYCHIATRY = "IAB7-37";
        public static final String SENIOR_HEALTH = "IAB7-38";
        public static final String SEXUALITY = "IAB7-39";
        public static final String SLEEP_DISORDERS = "IAB7-40";
        public static final String SMOKING_CESSATION = "IAB7-41";
        public static final String SUBSTANCE_ABUSE = "IAB7-42";
        public static final String THYROID_DISEASE = "IAB7-43";
        public static final String WEIGHT_LOSS = "IAB7-44";
        public static final String WOMENS_HEALTH = "IAB7-45";
    }

    public static final class FoodAndDrink {
        public static final String CATEGORY_CODE = "IAB8";

        public static final String AMERICAN_CUISINE = "IAB8-1";
        public static final String BARBECUES_AND_GRILLING = "IAB8-2";
        public static final String CAJUN_CREOLE = "IAB8-3";
        public static final String CHINESE_CUISINE = "IAB8-4";
        public static final String COCKTAILS_BEER = "IAB8-5";
        public static final String COFFEE_TEA = "IAB8-6";
        public static final String CUISINCE_SPECIFIC = "IAB8-7";
        public static final String DESSERTS_AND_BAKING = "IAB8-8";
        public static final String DINING_OUT = "IAB8-9";
        public static final String FOOD_ALLERGIES = "IAB8-10";
        public static final String FRENCH_CUISINE = "IAB8-11";
        public static final String HEALTH_LOW_FAT_COOKING = "IAB8-12";
        public static final String ITALIAN_CUISINE = "IAB8-13";
        public static final String JAPANESE_CUISINE = "IAB8-14";
        public static final String MEXICAN_CUISINE = "IAB8-15";
        public static final String VEGAN = "IAB8-16";
        public static final String VEGETARIAN = "IAB8-17";
        public static final String WINE = "IAB8-18";
    }

    public static final class HobbiesAndInterests {
        public static final String CATEGORY_CODE = "IAB9";

        public static final String ART_TECHNOLOGY = "IAB9-1";
        public static final String ARTS_AND_CRAFTS = "IAB9-2";
        public static final String BEADWORK = "IAB9-3";
        public static final String BIRD_WATCHING = "IAB9-4";
        public static final String BOARD_GAMES_PUZZLES = "IAB9-5";
        public static final String CANDLE_AND_SOAP_MAKING = "IAB9-6";
        public static final String CARD_GAMES = "IAB9-7";
        public static final String CHESS = "IAB9-8";
        public static final String CIGARS = "IAB9-9";
        public static final String COLLECTING = "IAB9-10";
        public static final String COMIC_BOOKS = "IAB9-11";
        public static final String DRAWING_SKETCHING = "IAB9-12";
        public static final String FREELANCE_WRITING = "IAB9-13";
        public static final String GENEALOGY = "IAB9-14";
        public static final String GETTING_PUBLISHED = "IAB9-15";
        public static final String GUITAR = "IAB9-16";
        public static final String HOME_RECORDING = "IAB9-17";
        public static final String INVESTOR_AND_PATENTS = "IAB9-18";
        public static final String JEWELRY_MAKING = "IAB9-19";
        public static final String MAGIC_AND_ILUSSION = "IAB9-20";
        public static final String NEEDLEWORK = "IAB9-21";
        public static final String PAINTING = "IAB9-22";
        public static final String PHOTOGRAPHY = "IAB9-23";
        public static final String RADIO = "IAB9-24";
        public static final String ROLEPLAYING_GAMES = "IAB9-25";
        public static final String SCIFI_AND_FANTASY = "IAB9-26";
        public static final String SCRAPBOOKING = "IAB9-27";
        public static final String SCREENWRITING = "IAB9-28";
        public static final String STAMPS_AND_COINS = "IAB9-29";
        public static final String VIDEO_AND_COMPUTER_GAMES = "IAB9-30";
        public static final String WOODWORKING = "IAB9-31";
    }

    public static final class HomeAndGarden {
        public static final String CATEGORY_CODE = "IAB10";

        public static final String APPLIANCES = "IAB10-1";
        public static final String ENTERTAINING = "IAB10-2";
        public static final String ENVIRONMENTAL_SAFETY = "IAB10-3";
        public static final String GARDENING = "IAB10-4";
        public static final String HOME_REPAIR = "IAB10-5";
        public static final String HOME_THEATER = "IAB10-6";
        public static final String INTERIOR_DECORATING = "IAB10-7";
        public static final String LANDSCAPING = "IAB10-8";
        public static final String REMODELING_AND_CONSTRUCTION = "IAB10-9";
    }

    public static final class LawGovernmentAndPolitics {
        public static final String CATEGORY_CODE = "IAB11";

        public static final String INMIGRATION = "IAB11-1";
        public static final String LEGAL_ISSUES = "IAB11-2";
        public static final String US_GOVERNMENT_RESOURCES = "IAB11-3";
        public static final String POLITICS = "IAB11-4";
        public static final String COMMENTARY = "IAB11-5";
    }

    public static final class News {
        public static final String CATEGORY_CODE = "IAB12";

        public static final String INTERNATIONAL = "IAB12-1";
        public static final String NATIONAL = "IAB12-2";
        public static final String LOCAL = "IAB12-3";
    }
}
