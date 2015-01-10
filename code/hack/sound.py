import soundcloud

client = soundcloud.Client(client_id='5df2e20e65c72711001296288126e420')
tracks = client.get('/tracks', q='partyomo')

for track in tracks:
    print(track.title)
