package com.devonfw.ide.sonarqube.common.impl.check;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.api.config.Component;

/**
 * {@link DevonArchitectureComponentCheck} verifying that a dataaccess layer does not depend on the dataaccess layer of
 * another {@link Component}.
 */
@Rule(key = "Devon4j:C6", name = "Devon Layer Dataaccess-Dataaccess Component Check", //
    description = "Verify that dataaccess layer may not depend on the dataaccess layer of another component.", //
    priority = Priority.MINOR, tags = { "architecture-violation" })
public class DevonArchitectureLayerDataaccess2Dataaccess4ComponentCheck extends DevonArchitectureComponentCheck {

  @Override
  protected String checkDependency(JavaType source, Component sourceComponent, JavaType target) {

    if (source.isLayerDataAccess() && target.isLayerDataAccess()
        && !isSameOrGeneralComponentWithSameOrCommonLayer(source, target)) {
      return "Code from dataaccess layer ('" + source.toString()
          + "') shall not depend on dataaccess layer of a different component ('" + target.toString() + "').";
    }
    return null;
  }

}
