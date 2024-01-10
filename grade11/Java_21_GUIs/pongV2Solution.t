
View.Set ("graphics: 800;640, offscreenonly, position: center;center")
setscreen ("nocursor")

var y1, paddle1Width, paddle1Thickness, p1Speed : int % paddle at bottom
var yy1, paddle2Width, paddle2Thickness, p2Speed : int % paddle at top

var chars : array char of boolean % movement of paddles

var c1x, c1y, c1radius : int % first circle variables


var c1xDelta, c1yDelta : int % for movement of 1st circle


var score1, score2 : int % scores

var colourcount : int := 1 % make ball flash colours

var scoreposition1, scoreposition2 : int % To move the score when > 9

% set the fonts for the displays
var winnerFont, playagainFont, titleFont, scoreFont : int

var key : string (1) % for getch

var dashWidth, dashHeight : int % dashes in the middle

% Give the variables values
dashWidth := 25
dashHeight := 10

% Initialize the circle 1 and circle 2 position and radius.
% set random locations for starting value of circles.
randint (c1x, 25, maxx - 25)
randint (c1y, 25, maxy - 25)
c1radius := 8

% the speed of circles
c1xDelta := 5
c1yDelta := 5

% Initialize the positioning and speed of the paddles

% bottom paddle
y1 := 20
paddle1Width := 120
paddle1Thickness := 10
p1Speed := 4

% top paddle
yy1 := 300
paddle2Width := 120
paddle2Thickness := 10
p2Speed := 4

% Initialize the positioning and value of the score
score1 := 0
score2 := 0
scoreposition1 := 0
scoreposition2 := 0

% Font Declarations
scoreFont := Font.New ("Swis721 Ex BT:160:bold")
assert scoreFont > 0

winnerFont := Font.New ("Arial:43:bold")
assert winnerFont > 0

playagainFont := Font.New ("Arial:27:bold")
assert playagainFont > 0

titleFont := Font.New ("Swis721 Ex BT:110:bold")
assert titleFont > 0

loop
    cls

    %background
    drawfill (maxx, maxy, black, black)

    % title
    Font.Draw ("PONG!", 0, 400, titleFont, white)
    Font.Draw ("Press any key to continue.", 34, 200, playagainFont, white)
    View.Update
    getch (key)

    %update the screen
    View.Update

    cls %clear

    %background
    drawfill (maxx, maxy, black, black)


    % How to play screen
    Font.Draw ("How to play", 90, 550, winnerFont, white)
    color (white)
    colorback (black)
    locatexy (0, 475)
    put "Player 1- You are the one on the bottom. You control your paddle with the left and right arrow keys."
    locatexy (0, 410)
    put "Player 2- You are the one on the top. You control your paddle"
    put "with the key 'a' for left and 'd' for right."
    locatexy (0, 250)
    put "The objective is to keep the ball from touching your side."
    locatexy (0, 200)
    put "If the ball touches your opponents side, then you receive a point"
    locatexy (0, 150)
    put "The first person to 15 points wins"
    View.Update

    getch (key) % wait for key

    loop
	cls
	% to make ball flash
	colourcount := colourcount + 1
	if colourcount > 55 then
	    colourcount := 32
	end if

	%background
	drawfill (maxx, maxy, black, black)

	% draw lines across middle vertically
	for k : 0 .. 15
	    drawfillbox (maxx div 2 + dashHeight div 2, 40 * k, maxx div 2 - dashHeight div 2, 40 * k + dashWidth, white)
	end for

	% Show the score value on the screen
	Font.Draw (intstr (score1), 500 - scoreposition1, 250, scoreFont, white)
	Font.Draw (intstr (score2), 150 - scoreposition2, 250, scoreFont, white)

	% draw paddles and circle
	drawfilloval (c1x, c1y, c1radius, c1radius, colourcount)   % ball 1

	drawfillbox (0, y1, paddle1Thickness, y1 + paddle1Width, white) % paddle at left

	drawfillbox (maxx, yy1, maxx - paddle2Thickness, yy1 + paddle2Width, white) % paddle at right

	delay (10)

	%User presses a key and paddle moves appropriately
	Input.KeyDown (chars)

	%Bottom player's keys
	if chars (KEY_DOWN_ARROW) and y1 > 0 then
	    y1 := y1 - p1Speed
	end if
	if chars (KEY_UP_ARROW) and y1 + paddle1Width < maxy then
	    y1 := y1 + p1Speed
	end if

	%Top player's keys
	if chars ('s') and yy1 > 0 then
	    yy1 := yy1 - p2Speed
	end if
	if chars ('w') and yy1 + paddle2Width < maxy then
	    yy1 := yy1 + p2Speed
	end if

	%Circle movement for first ball
	if c1x > maxx - c1radius - c1radius div 2 then
	    c1xDelta := -c1xDelta

	elsif c1x < c1radius + c1radius div 2 then
	    c1xDelta := abs (c1xDelta)
	end if

	if c1y > maxy - c1radius - c1radius div 2 then
	    c1yDelta := -c1yDelta
	elsif c1y < c1radius + c1radius div 2 then
	    c1yDelta := abs (c1yDelta)
	end if


	%First ball changes direction after it hits left player's paddle
	if c1x <= paddle1Thickness + c1radius + c1radius div 2 and c1y >= y1 and c1y <= y1 + paddle1Width then
	    c1xDelta := abs (c1xDelta)
	    c1x := paddle1Thickness + c1radius + c1radius div 2
	end if

	%First ball changes direction after it hits right player's paddle
	if c1x >= maxx - c1radius - c1radius div 2 - paddle2Thickness and c1y >= yy1 and c1y <= yy1 + paddle2Width then
	    c1xDelta := -c1xDelta
	    c1x := maxx - c1radius - c1radius div 2 - paddle2Thickness
	end if


	%Movement of the ball based on the direction it's traveling
	c1y := c1y + c1yDelta
	c1x := c1x + c1xDelta

	%Increases score for both players
	if c1x > maxx - c1radius - c1radius div 2 then
	    score2 := score2 + 1

	    drawfillbox (maxx, yy1, maxx - paddle2Thickness, yy1 + paddle2Width, brightgreen) % paddle at right
	    View.Update
	    delay (50)


	elsif c1x < c1radius + c1radius div 2 then
	    score1 := score1 + 1
	    drawfillbox (0, y1, paddle1Thickness, y1 + paddle1Width, brightgreen) % paddle at left
	    View.Update
	    delay (50)

	end if



	View.Update


	%Changes location of the score when the score is > 10
	if score1 >= 10 then
	    scoreposition1 := 100
	end if
	if score2 >= 10 then
	    scoreposition2 := 100
	end if

	exit when score1 = 15 or score2 = 15
    end loop

    % Winner of the game (first to 15)
    cls
    if score1 = 15 then
	drawfill (maxx, maxy, black, black)
	Font.Draw ("Player 2 wins,", 5, 400, winnerFont, white)
	Font.Draw (" <<<< the one on LEFT !", 5, 300, winnerFont, white)
    elsif score2 = 15 then
	drawfill (maxx, maxy, black, black)
	Font.Draw ("Player 1 wins,", 5, 400, winnerFont, white)
	Font.Draw ("the one on RIGHT >>> !", 5, 300, winnerFont, white)
    end if

    % play again?

    Font.Draw ("Play again? (y/n)", 90, 150, playagainFont, white)
    View.Update
    locatexy (50, 120)
    loop
	getch (key)

	if key = "n" then
	    exit
	elsif key = "y" then % resets the scores
	    score1 := 0
	    score2 := 0
	    scoreposition1 := 203
	    scoreposition2 := 203
	    randint (c1x, 25, maxx - 25)
	    randint (c1y, 25, maxy - 25)

	    exit
	end if
    end loop
    exit when key = "n"
end loop

cls
locate (maxx div 2, maxy div 2)
put "Thank you for playing"
