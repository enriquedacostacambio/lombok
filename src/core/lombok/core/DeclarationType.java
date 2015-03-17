package lombok.core;

import java.lang.annotation.Annotation;

import lombok.ConfigurationKeys;
import lombok.val;
import lombok.var;
import lombok.core.configuration.ConfigurationKey;
import lombok.core.configuration.FlagUsageType;

public class DeclarationType {
	public final Class<? extends Annotation> annotation;
	public final boolean isFinal;
	public final ConfigurationKey<FlagUsageType> usageFlag;
	public DeclarationType(Class<? extends Annotation> annotation, boolean isFinal, ConfigurationKey<FlagUsageType> usageFlag) {
		this.annotation = annotation;
		this.isFinal = isFinal;
		this.usageFlag = usageFlag;
	}
	
	public static final DeclarationType[] types = new DeclarationType[] {
		new DeclarationType(val.class, true, ConfigurationKeys.VAL_FLAG_USAGE),
		new DeclarationType(var.class, false, ConfigurationKeys.VAR_FLAG_USAGE)
	};
}