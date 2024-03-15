package ui.pages;

import lombok.Getter;

import static config.ConfigReader.getValue;

@Getter
public enum TalentLMS_PAGES {

    LOGIN_PAGE("https://" + getValue("domain") + ".talentlms.com/index"),
    MY_DOMAIN("https://" + getValue("domain")),
    TALENTLMS(".talentlms.com"),
    DASHBOARD("/dashboard"),
    USERS("/user/index"),
    BASIC_SETTINGS("/account/basic_index"),
    ACCOUNT_SETTINGS_USERS("/account/users_index"),
    THEMES("/account/themes_index"),
    CERTIFICATES("/account/certifications_index"),
    ECOMMERCE("/account/ecommerce_index"),
    DOMAIN("/account/domain_index"),
    GAMIFICATION("/account/gamification_index"),
    SUBSCRIPTION("/account/subscription_index"),
    STARTER_PLAN("/account/subscription_selectplan/plan:starter-annual-c2022,mode:upgrade"),
    BASIC_PLAN("/account/subscription_selectplan/plan:basic-annual-c2022,mode:upgrade"),
    PLUS_PLAN("/account/subscription_selectplan/plan:plus-annual-c2022,mode:upgrade"),
    PREMIUM_PLAN("/account/subscription_selectplan/plan:premium-annual-c2022,mode:upgrade"),
    USER_TYPES("/acl/index"),
    USER_REPORTS("/reports/user");
    public final String URL;

    TalentLMS_PAGES(String URL){
        this.URL = URL;
    }
}
