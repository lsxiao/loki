package com.lsxiao.rig.core.rule.`when`

import com.lsxiao.rig.core.rule.BaseRule
import com.lsxiao.rig.core.rule.RelyAble
import com.lsxiao.rig.core.rule.WhenAble

/**
 * write with BaseRule
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 当对应的字段值不为null的时候，验证字段才是必须的
 */

class WhenNotNullRule(override val params: Array<String>, override val relyName: String?, override val relyValue: String?) : BaseRule, WhenAble, RelyAble {
    companion object {
        val names = setOf("when_notnull")
    }

    override fun checkParams() = params.size == 1

    override fun check(checkedFiled: String?): Boolean = relyValue != null
}