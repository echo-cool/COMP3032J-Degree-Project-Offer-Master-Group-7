package com.group7.db.jpa.utils;

import java.util.Random;

public class RamdomSchoolImage {
    private String[] randomImages = new String[]{"image (1).avif","image (1).jpeg","image (1).jpg","image (1).png","image (1).webp","image (10).jpg","image (11).jpg","image (12).jpg","image (13).jpg","image (14).jpg","image (15).jpg","image (16).jpg","image (17).jpg","image (18).jpg","image (19).jpg","image (2).jpeg","image (2).jpg","image (2).webp","image (20).jpg","image (21).jpg","image (22).jpg","image (23).jpg","image (24).jpg","image (25).jpg","image (26).jpg","image (27).jpg","image (28).jpg","image (29).jpg","image (3).jpeg","image (3).jpg","image (3).webp","image (30).jpg","image (31).jpg","image (32).jpg","image (33).jpg","image (34).jpg","image (35).jpg","image (36).jpg","image (37).jpg","image (38).jpg","image (39).jpg","image (4).jpeg","image (4).jpg","image (4).webp","image (40).jpg","image (41).jpg","image (42).jpg","image (43).jpg","image (44).jpg","image (45).jpg","image (46).jpg","image (47).jpg","image (48).jpg","image (49).jpg","image (5).jpeg","image (5).jpg","image (5).webp","image (50).jpg","image (51).jpg","image (52).jpg","image (6).jpeg","image (6).jpg","image (6).webp","image (7).jpg","image (7).webp","image (8).jpg","image (9).jpg"};
    private Random random = new Random();
    public static String getRandomImage(){
        return "default/random_image"
    }
}
