
  Feature: prompt
    @pmessage
    Scenario: prompt
      Given kullanici herokuapp sitesine gider
      And click basic auth link
      Then assert the prompt
