/*
 * Copyright (c) 2023 looly(loolly@aliyun.com)
 * Hutool is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *          http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */

package org.dromara.hutool.log;

import org.dromara.hutool.core.lang.caller.CallerUtil;
import org.dromara.hutool.log.level.DebugLog;
import org.dromara.hutool.log.level.ErrorLog;
import org.dromara.hutool.log.level.InfoLog;
import org.dromara.hutool.log.level.Level;
import org.dromara.hutool.log.level.TraceLog;
import org.dromara.hutool.log.level.WarnLog;

/**
 * 日志统一接口
 *
 * @author Looly
 *
 */
public interface Log extends TraceLog, DebugLog, InfoLog, WarnLog, ErrorLog {

	// region Static method
	/**
	 * 获得Log
	 *
	 * @param clazz 日志发出的类
	 * @return Log
	 */
	static Log get(final Class<?> clazz) {
		return LogFactory.getLog(clazz);
	}

	/**
	 * 获得Log
	 *
	 * @param name 自定义的日志发出者名称
	 * @return Log
	 * @since 5.0.0
	 */
	static Log get(final String name) {
		return LogFactory.getLog(name);
	}

	/**
	 * @return 获得日志，自动判定日志发出者
	 * @since 5.0.0
	 */
	static Log get() {
		return LogFactory.getLog(CallerUtil.getCallerCaller());
	}
	// endregion

	/**
	 * @return 日志对象的Name
	 */
	String getName();

	/**
	 * 是否开启指定日志
	 * @param level 日志级别
	 * @return 是否开启指定级别
	 */
	boolean isEnabled(Level level);

	/**
	 * 打印指定级别的日志
	 * @param level 级别
	 * @param format 消息模板
	 * @param arguments 参数
	 */
	void log(Level level, String format, Object... arguments);

	/**
	 * 打印 指定级别的日志
	 *
	 * @param level 级别
	 * @param t 错误对象
	 * @param format 消息模板
	 * @param arguments 参数
	 */
	void log(Level level, Throwable t, String format, Object... arguments);

	/**
	 * 打印 ERROR 等级的日志
	 *
	 * @param fqcn 完全限定类名(Fully Qualified Class Name)，用于定位日志位置
	 * @param level 级别
	 * @param t 错误对象
	 * @param format 消息模板
	 * @param arguments 参数
	 */
	void log(String fqcn, Level level, Throwable t, String format, Object... arguments);
}
