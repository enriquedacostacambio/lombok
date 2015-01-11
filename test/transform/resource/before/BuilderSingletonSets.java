import java.util.Set;
import java.util.SortedSet;

import lombok.Singular;

@lombok.Builder
class BuilderSingletonSets<T> {
	@Singular private Set<T> dangerMice;
	@Singular private SortedSet<? extends Number> octopodes;
	@Singular("rawSet") private Set rawSet;
	@Singular("stringSet") private Set<String> stringSet;
}