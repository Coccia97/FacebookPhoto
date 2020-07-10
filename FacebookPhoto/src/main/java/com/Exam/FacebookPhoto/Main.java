package com.Exam.FacebookPhoto;
import com.Exam.FacebookPhoto.service.DownloadFromURL;

public class Main {

	public static void main(String[] args) {
		String url = "https://graph.facebook.com/v7.0/3120253634680310?fields=photos&access_token=EAAH51tUzLoUBAGHLvCtdXIkoJZAIpYsZCk7L34GO5OT1l3mi75zFwQd9zEUMfO3aJgw7qICgqFbT0MbdG5eL0WBJfI7SjA1a4Rg3dmZBL1j5UZByxdZBAYpJZChr1t0QLxnNlk9uSZACNUeUkuDrZCtgHAWvV0zN6ORpShU3C43TllDRQKBGikUTaZC3cs9rbVpCnED2ZCvGgozLKF7Qex2ZCUBgGSp3SpEc7IY45vnIGFjpQZDZD";
		DownloadFromURL json = new DownloadFromURL();
		String test1=json.JsonToString(url);
		System.out.println(test1);
	}

}
