package com.lsxiao.rig.core

import com.lsxiao.rig.core.rule.BaseRule
import com.lsxiao.rig.core.rule.length.LengthRule
import com.lsxiao.rig.core.rule.length.MaxLengthRule
import com.lsxiao.rig.core.rule.length.MinLengthRule
import com.lsxiao.rig.core.rule.numeric.IntegerRule
import com.lsxiao.rig.core.rule.numeric.MaxRule
import com.lsxiao.rig.core.rule.numeric.MinRule
import com.lsxiao.rig.core.rule.numeric.NumericRule
import com.lsxiao.rig.core.rule.other.*
import com.lsxiao.rig.core.rule.value.SameAsRule
import com.lsxiao.rig.core.rule.value.SameRule

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-01 17:26
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 *
 * 失败消息模板
 */

object FailTemplate {
    val NAME = ":name"
    val VALUE = ":value"
    val ARG = ":arg"
    val ARG1 = "${ARG}1"
    val ARG2 = "${ARG}2"
    val RELY_VALUE = ":rely_value"
    val RELY_NAME = ":rely_name"


    val zhCN = hashMapOf(
            NotNullRule::class.java to "不能为null",
            FilledRule::class.java to "不能为空字符串",
            IntegerRule::class.java to "必须是整数",
            NumericRule::class.java to "必须是数字",
            LengthRule::class.java to "长度必须等于$ARG",
            MaxLengthRule::class.java to "长度不能大于$ARG",
            SameRule::class.java to "值必须等于$ARG",
            SameAsRule::class.java to "值必须与字段 '${RELY_NAME}' 相等",
            MinLengthRule::class.java to "长度不能小于$ARG",
            MinRule::class.java to "不能小于 $ARG",
            MaxRule::class.java to "不能大于 $ARG",
            MobileRule::class.java to "不是有效的手机格式",
            EmailRule::class.java to "不是有效的邮箱格式",
            LetterRule::class.java to "必须是字母",
            HanRule::class.java to "必须是汉字",
            UrlRule::class.java to "不是有效的网址"
    )

    val zhTW = hashMapOf(
            NotNullRule::class.java to "不能为null",
            FilledRule::class.java to "不能为空字符串",
            IntegerRule::class.java to "必须是整数",
            NumericRule::class.java to "必须是数字",
            LengthRule::class.java to "长度必须等于$ARG",
            MaxLengthRule::class.java to "长度不能大于$ARG",
            SameRule::class.java to "值必须等于$ARG",
            SameAsRule::class.java to "值必须与字段 '${RELY_NAME}' 相等",
            MinLengthRule::class.java to "长度不能小于$ARG",
            MinRule::class.java to "不能小于 $ARG",
            MaxRule::class.java to "不能大于 $ARG",
            MobileRule::class.java to "不是有效的手机格式",
            EmailRule::class.java to "不是有效的邮箱格式",
            LetterRule::class.java to "必须是字母",
            HanRule::class.java to "必须是汉字",
            UrlRule::class.java to "不是有效的网址"
    )


    val en = hashMapOf(
            NotNullRule::class.java to "不能为null",
            FilledRule::class.java to "不能为空字符串",
            IntegerRule::class.java to "必须是整数",
            NumericRule::class.java to "必须是数字",
            LengthRule::class.java to "长度必须等于$ARG",
            MaxLengthRule::class.java to "长度不能大于$ARG",
            SameRule::class.java to "值必须等于$ARG",
            SameAsRule::class.java to "值必须与字段 '${RELY_NAME}' 相等",
            MinLengthRule::class.java to "长度不能小于$ARG",
            MinRule::class.java to "不能小于 $ARG",
            MaxRule::class.java to "不能大于 $ARG",
            MobileRule::class.java to "不是有效的手机格式",
            EmailRule::class.java to "不是有效的邮箱格式",
            LetterRule::class.java to "必须是字母",
            HanRule::class.java to "必须是汉字",
            UrlRule::class.java to "不是有效的网址"
    )


    val i18n = linkedMapOf(
            "zh-CN" to zhCN,
            "zh-TW" to zhTW,
            "en" to en
    )


    fun render(name: String, args: Array<String>, relyName: String, relyValue: String, template: String?): String? {
        return template
                ?.replace(NAME, name)
                ?.replace(VALUE, name)
                ?.replace(RELY_NAME, relyName)
                ?.replace(RELY_VALUE, relyValue)
                ?.replace(ARG, ARG1)
                ?.replace(ARG1, "%1\$s")
                ?.replace(ARG2, "%2\$s")
                ?.format(*args)
    }

    fun get(clazz: Class<out BaseRule>): String? {
        return i18n.values.first().get(clazz)
    }

}
