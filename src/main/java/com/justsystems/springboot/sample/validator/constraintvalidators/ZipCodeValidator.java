package com.justsystems.springboot.sample.validator.constraintvalidators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.justsystems.springboot.sample.validator.constraints.ZipCode;


public class ZipCodeValidator  implements ConstraintValidator<ZipCode, CharSequence> {

    /** プロファイル種別 */
    private static String zipCodePattern = "[0-9]{3}+-[0-9]{4}+";

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(ZipCode constraint) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return isZipCode(value.toString(), zipCodePattern);
    }

    /**
     * 郵便番号の形式チェック
     *
     * @param zip 郵便番号
     * @return 郵便番号形式の場合<code>true</code>
     */
    public static boolean isZipCode(String zip, String regex) {
        if (regex == null) {
            return isPatternMatch(zip,  zipCodePattern);
        }
        return isPatternMatch(zip, regex);
    }


    /**
     * 正規表現に合った形式チェック
     *
     * @param string 文字列
     * @param regex 正規表現
     * @return 正規表現に合った形式の場合<code>true</code>
     */
    public static boolean isPatternMatch(String string, String regex) {
        if (string != null && regex != null) {
            Matcher matcher = Pattern.compile(regex).matcher(string);
            return matcher.matches();
        }
        return false;
    }
}
