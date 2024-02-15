package pages;

public enum URL_TalentLMS {

    TALENTLMS_MAIN_PAGE("https://www.talentlms.com/"),
    DASHBOARD_PAGE("https://fall2023.talentlms.com/dashboard"),
    BASIC_SETTINGS_PAGE("https://fall2023.talentlms.com/account/basic_index"),
    DOMAIN_PAGE("https://fall2023.talentlms.com/account/domain_index"),
    THEMES_PAGE("https://fall2023.talentlms.com/account/themes_index"),
    GAMIFICATION_PAGE("https://fall2023.talentlms.com/account/gamification_index"),
    SUBSCRIPTION_PAGE("https://fall2023.talentlms.com/account/subscription_index"),
    STARTER_PLAN_PAGE("https://fall2023.talentlms.com/account/subscription_selectplan/plan:starter-annual-c2022,mode:upgrade"),
    BASIC_PLAN_PAGE("https://fall2023.talentlms.com/account/subscription_selectplan/plan:basic-annual-c2022,mode:upgrade"),
    PLUS_PLAN_PAGE("https://fall2023.talentlms.com/account/subscription_selectplan/plan:plus-annual-c2022,mode:upgrade"),
    PREMIUM_PLAN_PAGE("https://fall2023.talentlms.com/account/subscription_selectplan/plan:premium-annual-c2022,mode:upgrade");

    public final String URL;

    URL_TalentLMS(String URL){
        this.URL = URL;
    }

    @Override
    public String toString() {
        return URL;
    }
}
