package com.company;


import java.util.*;

public class AdsConversionRate {

    public static String[] completed_purchase_user_ids = new String[]{"3123122444", "234111110", "8321125440", "99911063"};

    public static void getAdsConversionRate() {


        String[] ad_clicks = new String[]{"122.121.0.1,2016-11-03 11:41:19,Buy wool coats for your pets",
                "96.3.199.11,2016-10-15 20:18:31,2017 Pet Mittens",
                "122.121.0.250,2016-11-01 06:13:13,The Best Hollywood Coats",
                "82.1.106.8,2016-11-12 23:05:14,Buy wool coats for your pets",
                "92.130.6.144,2017-01-01 03:18:55,Buy wool coats for your pets",
                "92.130.6.145,2017-01-01 03:18:55,2017 Pet Mittens"};

        String[] all_user_ips = new String[]{"2339985511,122.121.0.155",
                "234111110,122.121.0.1",
                "3123122444,92.130.6.145",
                "39471289472,2001:0db8:ac10:fe01:0000:0000:0000:0000",
                "8321125440,82.1.106.8",
                "99911063,92.130.6.144"};

        findAdsConversionRate(completed_purchase_user_ids, ad_clicks, all_user_ips);
    }

    private static void findAdsConversionRate(String[] completed_purchase_user_ids, String[] ad_clicks, String[] all_user_ips) {
        HashSet<String> completedPurchaseUserIds = new HashSet<>();
        HashMap<String, String> ipUserIdMap = new HashMap<>();
        HashMap<String, String> ipAdTextMap = new HashMap<>();
        Arrays.stream(completed_purchase_user_ids).forEach(s -> completedPurchaseUserIds.add(s));

        for (int i = 0; i < all_user_ips.length; i++) {
            String ipUserIdData = all_user_ips[i];
            String[] ipUserIdDataTokens = ipUserIdData.split(",");
            if (!ipAdTextMap.containsKey(ipUserIdDataTokens[0]))
                ipUserIdMap.put(ipUserIdDataTokens[1], ipUserIdDataTokens[0]);
        }
        HashMap<String, Integer> totalAdClicks = new HashMap<>();
        HashMap<String, Integer> noOfValidAdClicks = new HashMap<>();
        for (int i = 0; i < ad_clicks.length; i++) {
            String adClicksRawData = ad_clicks[i];
            String[] adClicksRawDataTokens = adClicksRawData.split(",");
            ipAdTextMap.put(adClicksRawDataTokens[0], adClicksRawDataTokens[2]);

            if (!totalAdClicks.containsKey(adClicksRawDataTokens[2])) {
                totalAdClicks.put(adClicksRawDataTokens[2], 1);
            } else {
                int val = totalAdClicks.get(adClicksRawDataTokens[2]);
                totalAdClicks.put(adClicksRawDataTokens[2], ++val);
            }
            String userIdForGivenIP = ipUserIdMap.getOrDefault(adClicksRawDataTokens[0], null);
            if (userIdForGivenIP != null) {
                if (completedPurchaseUserIds.contains(userIdForGivenIP))
                {
                    if (!noOfValidAdClicks.containsKey(adClicksRawDataTokens[2]))
                        noOfValidAdClicks.put(adClicksRawDataTokens[2], 1);
                    else {
                        int val = noOfValidAdClicks.get(adClicksRawDataTokens[2]);
                        noOfValidAdClicks.put(adClicksRawDataTokens[2], ++val);
                    }
                }

            }
        }

        for(Map.Entry<String, Integer> entry : totalAdClicks.entrySet()) {
            String adText = entry.getKey();
            int totalClicks = totalAdClicks.get(adText);
            int validClicks = noOfValidAdClicks.getOrDefault(adText, 0);
            System.out.println(validClicks + " of " + totalClicks + " " + adText);
        }
    }








}



