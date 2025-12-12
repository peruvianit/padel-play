package it.peruvianit.core.i18n;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.inject.Inject;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@ApplicationScoped
public class MessageResolver {

    private static final String BASE_NAME = "i18n.messages";
    private static final Locale DEFAULT_LOCALE = Locale.ITALIAN;

    @Inject
    HttpHeaders headers;

    public String resolve(String key, Object... params) {

        Locale locale = resolveLocale();
        ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME, locale);

        String pattern = bundle.getString(key);
        return MessageFormat.format(pattern, params);
    }

    private Locale resolveLocale() {

        if (headers == null) {
            return DEFAULT_LOCALE;
        }

        List<Locale> languages = headers.getAcceptableLanguages();
        if (languages == null || languages.isEmpty()) {
            return DEFAULT_LOCALE;
        }

        return languages.get(0);
    }
}
