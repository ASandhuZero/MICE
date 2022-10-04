INCLUDE Character.ink
INCLUDE Inquiry.ink
INCLUDE Event.ink
INCLUDE Milieu.ink


This demo focuses on a computational model of MICE, a novelist technique for writing more cohesive stories.

* [Start] 
    -> Start

* [How this demo works]
    -> Explanation
    
== Explanation
The focus of this demo is showing off how ABL changes the story state.
As of now, MICE consistency is on for the demo, however, the player can turn off MICE consistency by clicking on the button at the top right.

-> Epilogue

VAR text = "Test; filler variable"
VAR state = "null"


=== Start ===
~ state = "Start"
# Start of the story
Umbral darkness stretches itself over me as the starship flies over. I wonder what story of blight lives within those desecrated halls. But as the ink-stained ship passes through, the shadow disappearing, the vivid red of a skyline tarnished by technology presents itself to me.

As the siren screams its shrill song once more, I grab at a memory, when these skies were a verdant ocean of blues and greens. But I should purge the reminders of the past from my mind. I can't waste time, now. 

*** Find out more about the spaceships. (Inquiry) -> Spaceship_questions
*** Ruminate on the past. (Character) -> Questioning_the_past

=== Spaceship_questions
~ state = "Spaceship_questions"
# InquiryStart
# Location : Archtorrent
Working throughout the day, a question comes to me: Why are these ships here?

So, I ask a friend—well, more of an acquaintance. 

He looks at me with a sadness in his gaze. "Those are the necromancers."

*** Necromancers -> an_answer

=== an_answer
~ state = "begin"
# InquiryContinue
He nods his head. "Aye. Necromancers. Foulest of the undying empire. A dark blight upon our common race. A manifestation of a bleak future, if you ask me."

He shrugs his shoulders. "But they control the land."

*** Say nothing  -> Event_start
*** Ask a follow up -> An_end_to_questions

=== Event_start
~ state = "EventStart"
# Event Start
Something happens that disrupts the flow of the narrative.
-> event_end

=== event_end
~ state = "EventEnd"
# Event End
Weird extra sentence for padding... I don't know why.

A darkness burst forth around us, scaring even me. 


*** Run from the darkness -> Avoiding_void
*** Restart the game (Debug) -> Epilogue

=== Avoiding_void
~ state = "Running away"
I run away from the darkness. It chases after me.

*** Escape by hiding -> stowaway
*** Confront the darkness -> confront_violence

=== stowaway
~ state = "Hiding" 
I hid myself in an open crate, letting the darkness pass by me. 
I wasn't scared so much as I was curious. Why did it chase me? (Opening an inquiry thread).
-> Back_to_the_friend

=== confront_violence
~ state = "talking to darkness"
The darkness passed by me, leaving me wondering one thing. Why? (Inquiry thread should open.)
-> Back_to_the_friend

=== Back_to_the_friend
~ state = "conversation continue"
I returned to my friend. 

"So," he said. "You got the mark."

*** What do you mean? -> An_end_to_questions
** Say nothing -> cold_shoulder

=== cold_shoulder
~ state = "Cold shoulder"
My friend looked me over, his eyes discerning. Then he shook his head. "You're more trouble than you're worth."

-> Epilogue

=== An_end_to_questions
~ state = "InquiryEnd"
# InquiryEnd
FILLER TEXT FOR DEMO END. 
-> Epilogue

=== Questioning_the_past
~ state = "CharacterStart"
# Location: Hedrift's home.

When I was young, not wrinkled by time and leathered by the sun, I was known as Hedrift. Yet, now I am known as the Fourth. 

-> Epilogue

=== Epilogue
~ state = "Epilogue"
# Epilogue
Thank you for playing!
-> END

NOTES:
    The computational version of MICE will have a try cycle per choice.
-> END
    Choices are try cycles within the narrative. (So now the narrative is about how much you try things? One possibility.)
