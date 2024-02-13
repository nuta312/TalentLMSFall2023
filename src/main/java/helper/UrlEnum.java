package helper;

public enum UrlEnum {

        TALANTLMS("https://www.talentlms.com/"),
        DEMOQA("https://demoqa.com/"),
        DIGITALNOMADS("https://digitalnomads.talentlms.com/");

        private final String url;

        UrlEnum(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

    }


