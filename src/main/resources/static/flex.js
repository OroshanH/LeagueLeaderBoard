

async function fetchUserList() {
    try {
        const response = await fetch('http://localhost:8080/api/brukere');
        const users = await response.json();
        return users;
    } catch (error) {
        console.error('Error fetching user data:', error);
    }
}

async function fetchAndDisplayLeagueData(summonerKey, navn, users) {
    try {
        const response = await fetch(`https://euw1.api.riotgames.com/lol/league/v4/entries/by-summoner/${summonerKey}?api_key=RGAPI-e31dd43c-0e02-4771-b5fd-ff882fd59324`);
        const data = await response.json();

        const soloQEntry = data.find(entry => entry.queueType === 'RANKED_FLEX_SR');

        if (soloQEntry) {

            const userToUpdate = users.find(user => user.summonerKey === summonerKey);

            if (userToUpdate) {

                const summonerName = userToUpdate.summonerName;
                const wins = soloQEntry.wins;
                const losses = soloQEntry.losses;
                const tier = soloQEntry.tier;
                const rank = soloQEntry.rank;
                const leaguePoints = soloQEntry.leaguePoints;


                userToUpdate.rank = `${tier} ${rank}`;
                userToUpdate.leaguePoints = leaguePoints;
                userToUpdate.wins = wins;
                userToUpdate.losses = losses;
                userToUpdate.tier = tier;



                displayUser(userToUpdate);
            } else {
                console.error(`No user found for summoner key ${summonerKey}`);
            }
        } else {
            console.error(`No data found for summoner key ${summonerKey}`);
        }
    } catch (error) {
        console.error(`Error fetching data for summoner key ${summonerKey}:`, error);
    }
}
function displayUser(user,rank) {
    const containerDiv = document.createElement('div');
    containerDiv.className = 'leaderboard-row';


    const leftSectionDiv = document.createElement('div');
    leftSectionDiv.style.display = 'flex';
    leftSectionDiv.style.alignItems = 'center';


    const rankNumberDiv = document.createElement('div');
    rankNumberDiv.className = 'rank-number';
    rankNumberDiv.textContent = rank;
    leftSectionDiv.appendChild(rankNumberDiv);


    const rolePictureImg = document.createElement('img');
    rolePictureImg.src = user.rolePictureUrl;
    rolePictureImg.alt = 'Role Picture';
    rolePictureImg.style.width = '30px';
    rolePictureImg.style.height = '30px';
    rolePictureImg.style.marginRight = '20px';
    leftSectionDiv.appendChild(rolePictureImg);


    const profilePictureImg = document.createElement('img');
    profilePictureImg.src = user.profilePictureUrl;
    profilePictureImg.alt = 'Profile Picture';
    profilePictureImg.style.width = '65px';
    profilePictureImg.style.height = '65px';
    profilePictureImg.classList.add('profile-picture');
    leftSectionDiv.appendChild(profilePictureImg);


    const summonerNameDiv = document.createElement('div');
    summonerNameDiv.style.marginLeft = '10px';
    summonerNameDiv.textContent = user.summonerName;
    leftSectionDiv.appendChild(summonerNameDiv);


    leftSectionDiv.style.width = '300px';


    const middleSectionDiv = document.createElement('div');
    middleSectionDiv.style.display = 'flex';
    middleSectionDiv.style.alignItems = 'center';


    const rankIconImg = document.createElement('img');
    rankIconImg.src = `/bilder/${user.tier}.png`;
    rankIconImg.alt = `${user.rank} Icon`;
    rankIconImg.style.width = '80px';
    middleSectionDiv.appendChild(rankIconImg);


    const infoDiv = document.createElement('div');
    infoDiv.style.marginLeft = '10px';
    infoDiv.textContent = `${user.rank} LP: ${user.leaguePoints}`;
    middleSectionDiv.appendChild(infoDiv);


    middleSectionDiv.style.width = '300px';


    const rightSectionDiv = document.createElement('div');

    const totalGames = user.wins + user.losses;
    const winRate = totalGames > 0 ? Math.round((user.wins / totalGames) * 100) + '%' : 'N/A';

    rightSectionDiv.textContent = `${user.wins}W - ${user.losses}L - ${winRate}`;

    rightSectionDiv.style.width = '200px'


    containerDiv.appendChild(leftSectionDiv);
    containerDiv.appendChild(middleSectionDiv);
    containerDiv.appendChild(rightSectionDiv);


    document.getElementById('leaderboard-container').appendChild(containerDiv);
}


function displayUsers(users) {

    const leaderboardContainer = document.getElementById('leaderboard-container');
    leaderboardContainer.innerHTML = '';


    for (let i = 0; i < users.length; i++) {
        const user = users[i];
        displayUser(user, i + 1);
    }
}

async function fetchAndDisplayUsersData() {

    const users = await fetchUserList();


    for (const user of users) {
        await fetchAndDisplayLeagueData(user.summonerKey, user.summonerName, users);
    }
    users.sort((a, b) => {

        const tierOrder = {
            'IRON': 1,
            'BRONZE': 2,
            'SILVER': 3,
            'GOLD': 4,
            'PLATINUM': 5,
            'EMERALD': 6,
            'DIAMOND': 7,
            'MASTER': 8,
            'GRANDMASTER': 9,
            'CHALLENGER': 10
        };

        const tierComparison = tierOrder[b.rank.split(' ')[0]] - tierOrder[a.rank.split(' ')[0]];
        if (tierComparison !== 0) {
            return tierComparison;
        }

        const rankOrder = { 'I': 4, 'II': 3, 'III': 2, 'IV': 1 };
        const rankComparison = rankOrder[b.rank.split(' ')[1]] - rankOrder[a.rank.split(' ')[1]];
        if (rankComparison !== 0) {
            return rankComparison;
        }
        return b.leaguePoints - a.leaguePoints;
    });

    displayUsers(users);
}
fetchAndDisplayUsersData();
