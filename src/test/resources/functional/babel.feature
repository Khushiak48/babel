@homepage
Feature: Verificaton of babel website

  Background: 
    Given Go to "http://babel.es/en/"
    And Maximize the window
    And Set the implicitly time

  Scenario Outline: Selecting all services navigates to respective page
    Given Keep the mouse on services heading
    When I click on type of sub- services <Services>
    Then Verify all the <Title> of sub-services page

    Examples: 
      | Services           | Title                                            |
      | Digital User       | Digital User - BABEL Sistemas de Informaci       |
      | Business Analytics | Business Analytics - BABEL Sistemas de Informaci |
      | New Architectures  | New Architectures - BABEL Sistemas de Informaci  |
      | Processes          | Processes - BABEL Sistemas de Informaci          |
      | Outsourcing - AM   | Outsourcing - AM - BABEL Sistemas de Informaci   |
      | Outsourcing - IM   | Outsourcing - IM - BABEL Sistemas de Informaci   |
      | Success Stories    | Success Stories - BABEL Sistemas de Informaci    |

  Scenario Outline: Selecting all about babel navigates to respective page
    Given Keep the mouse on about babel heading
    When I click types of <About Babel>
    Then Verify all the <Title>,<URL> of sub-link page

    Examples: 
      | About Babel            | Title                                                | URL                                                   |
      | Learn about BABEL      | Learn about BABEL - BABEL Sistemas de Informaci      | http://babel.es/en/about-babel/learn-about-babel      |
      | Partners               | Partners - BABEL Sistemas de Informaci               | http://babel.es/en/sobre-babel/partners               |
      | Quality                | Quality - BABEL Sistemas de Informaci                | http://babel.es/en/sobre-babel/calidad                |
      | Digital Transformation | Digital Transformation - BABEL Sistemas de Informaci | http://babel.es/en/sobre-babel/transformacion-digital |

  Scenario Outline: Selecting all solutions navigates to respective page
    Given Keep the mouse on solutions heading
    When I click on type of solutions <Solutions>
    Then Verify all the <Title>,<URL> of sub-solution page

    Examples: 
      | Solutions     | Title                                       | URL                                         |
      | Direct Writer | Direct Writer - BABEL Sistemas de Informaci | http://babel.es/en/soluciones/direct-writer |
      | Motiva        | Motiva - BABEL Sistemas de Informaci        | http://babel.es/en/soluciones/motiva        |
      | BCOM          | BCOM - BABEL Sistemas de Informaci          | http://babel.es/en/soluciones/bcom          |
      | Kentico       | Kentico - BABEL Sistemas de Informaci       | http://babel.es/en/soluciones/kentico       |
      | Serex         | Serex - BABEL Sistemas de Informaci         | http://babel.es/en/soluciones/serex         |
      | Office 365    | Office 365 - BABEL Sistemas de Informaci    | http://babel.es/en/soluciones/office-365    |

  Scenario Outline: Verify the direct writer headings
    Given Keep the mouse on solutions heading
    When I click on Direct Writer
    And Scroll down the page
    Then Verify the insurance management platform tabs <Direct Writer>

    Examples: 
      | Direct Writer |
      | Advantages    |
      | Target        |
      | Use cases     |
      | Technology    |

  Scenario: Verify Services
    Given Keep the mouse on services heading
    When I click on "Digital User"
    Then Verify the heading "User"
