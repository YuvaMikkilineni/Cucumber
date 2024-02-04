Feature: TurnUpPortal

Background:
Given user logs into turnup portal 'hari' '123123'
When user navigates to TM page

Scenario: Verify user is able to create TM record
When user creates a new TM record 'January2024-Yuva' 'Automation Testing- Yuva' '100'
Then TM record should be saved

Scenario Outline: Verify user is able to edit TM record
When user edits a TM record '<code>' '<description>' '<price>'
Then TM record should be Edited

Examples:
| code              | description       | price |
| January2024-Yuva1 | Automation Testing- Yuva1 | 50    |
	#| January2024-Yuva2 | Automation Testing- Yuva2 | 75    |

Scenario: Verify user is able to delete TM record
When user deletes a  TM record
Then TM record should be deleted