@homepage
Feature: HomePage

  Background: 
    Given Go to "http://babel.es/en/"
    And Maximize the window
    And Set the implicitly time

  Scenario Outline: Selecting all services navigates to respective page
    Given Keep the mouse on services heading
    When I click on type of sub- services <Services>
    Then Verify all the <Title> of sub-services page

    Examples: 
      | Services           | Title                                               |
      | Digital User       | Digital User - BABEL Sistemas de Información       |
      | Business Analytics | Business Analytics - BABEL Sistemas de Información |
      | New Architectures  | New Architectures - BABEL Sistemas de Información  |
      | Processes          | Processes - BABEL Sistemas de Información          |
      | Outsourcing - AM   | Outsourcing - AM - BABEL Sistemas de Información   |
      | Outsourcing - IM   | Outsourcing - IM - BABEL Sistemas de Información   |
      | Success Stories    | Success Stories - BABEL Sistemas de Información    |

  Scenario Outline: Selecting all about babel navigates to respective page
    Given Keep the mouse on about babel heading
    When I click types of <About Babel>
    Then Verify all the <Title>,<URL> of sub-link page

    Examples: 
      | About Babel            | Title                                                   | URL                                                   |
      | Learn about BABEL      | Learn about BABEL - BABEL Sistemas de Información      | http://babel.es/en/about-babel/learn-about-babel      |
      | Partners               | Partners - BABEL Sistemas de Información               | http://babel.es/en/sobre-babel/partners               |
      | Quality                | Quality - BABEL Sistemas de Información                | http://babel.es/en/sobre-babel/calidad                |
      | Digital Transformation | Digital Transformation - BABEL Sistemas de Información | http://babel.es/en/sobre-babel/transformacion-digital |

  Scenario Outline: Selecting all solutions navigates to respective page
    Given Keep the mouse on solutions heading
    When I click on type of <Solutions>
    Then Verify all the <Title>,<URL> of sub-solution page

    Examples: 
      | Solutions                              | Title                                          | URL                                         |
      | Direct Writer                          | Direct Writer - BABEL Sistemas de Información | http://babel.es/en/soluciones/direct-writer |
      | Motiva                                 | Motiva - BABEL Sistemas de Información        | http://babel.es/en/soluciones/motiva        |
      | BCOM                                   | BCOM - BABEL Sistemas de Información          | http://babel.es/en/soluciones/bcom          |
      | Kentico                                | Kentico - BABEL Sistemas de Información       | http://babel.es/en/soluciones/kentico       |
      | Serex                                  | Serex - BABEL Sistemas de Información         | http://babel.es/en/soluciones/serex         |
      | Office 365                             | Office 365 - BABEL Sistemas de Información    | http://babel.es/en/soluciones/office-365    |
      #Scenario Outline: Verify partner categories (error coming) -1st
      # Given Keep the mouse on about babel heading
      #When I click on partners
      #And Scroll down the page with <Coordinates>
      #Then Verify the headings of <Partners> field
      # Examples:
      #  | Coordinates                            | Partners           |
      #  |                                  0,500 | Gold Partners      |
      #  |                                 0,1000 | Strategic Partners |
      #Scenario Outline: Verify the linkedin link in orange background -error coming
      # When Click on linkedin link
      # Then I can see linkedin page
      #  And Verify the url of child linkedin page <URL>
      #  Examples:
      | URL                                    |                                                |                                             |
      | https://www.linkedin.com/company/babel |                                                |                                             |

    #  Scenario Outline: Verify the twitter link in in orange background -error coming
    # When Click on twitter link
    # Then I can see twitter page
    #  And Verify the child linkedin page <URL>
    Examples: 
      | URL                            |
      | https://twitter.com/babelgrupo |

  Scenario: Verify the twitter link in footer
    When Click on twitter link
    Then I can see twitter page

  Scenario: Verify Services
    Given Keep the mouse on services heading
    When I click on "Digital User"
    Then Verify the heading "User"
    # Scenario: Search the content ( pending task)
    When I click on search button
    And Type the content to search "People"
    And click on search
    Then Verify the search result "People"

  Scenario: Search the content
    When I click on search button
    And Type the content to search
    And click on close button
    Then Verify the same page

  Scenario Outline: 
    Given Keep the mouse on solutions heading
    When I click on Direct Writer
    And Scroll down the page
    Then Verify the insurance management platform tabs <Direct Writer> , <Description>

    Examples: 
      | Direct Writer | Description                                                                                                              |
      | Advantages    | the products workshop allows for the launching of new insurance products in hours                                        |
      | Target        | "Insurance companies, mutual fund companies and risk assessment agencies."                                               |
      | Use cases     | "Substitution of legacy systems. Migration due to difficulties in maintenance or competitiveness in the current system." |
      | Technology    | Direct Writer is developed using                                                                                         |

  Scenario: Verify the video
    When i click on video button
    And New frame window open
    And Click on video button
    And Pause the video
    And Play it again
    And set the volume
    And mute the video
    And Unmute the video
