package com.lsxiao.rig.core.rule.length

import com.lsxiao.rig.core.rule.BaseRule
import com.lsxiao.rig.core.rule.ParamAble

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-02 14:57
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class MaxLengthRule(override val params: Array<String>) : BaseRule, ParamAble {
    companion object {
        val names = setOf("max_length", "max_len")
    }

    override fun checkParams(): Boolean {
        return params.size == 1 && params.first().toIntOrNull() != null
    }

    override fun check(checkedFiled: String?): Boolean {
        return checkedFiled != null && checkedFiled.length <= params.first().toInt()
    }
}