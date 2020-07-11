package com.Exam.FacebookPhoto;
import com.Exam.FacebookPhoto.Model.Metadata;
import com.Exam.FacebookPhoto.service.DownloadFromURL;
import com.Exam.FacebookPhoto.service.StringParser;

public class Main {

	public static void main(String[] args) {
		String url = "https://graph.facebook.com/v7.0/3120253634680310?fields=photos&access_token=EAAH51tUzLoUBAFlGWQHdhM3dn9CYAzb647FpvTAPiHuOT5sDG8i6Eyol2f9ZBLGSbxhbNUPKTlxopprXKLwr1dslgP7wwZBXrI4VCGRJtRXl55y3GLa1E4ciCFz9QZAiSqeRAfh2WJ9vlZCXktPIMYq9OQHi433Bhhm2TDBIZBesPdRfmIhxhZBXlX9J0WLpMnzwZByDsGMsndWG5ch0SeEQuuRD69ZCsXSfL8kh4PAXggZDZD";
		DownloadFromURL json = new DownloadFromURL();
		String test1=json.JsonToString(url);
		System.out.println(test1);
		Metadata s1= StringParser.StringToPhotos(test1);
	}

}
