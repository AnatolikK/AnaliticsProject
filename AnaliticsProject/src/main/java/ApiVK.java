import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.groups.UserXtrRole;
import com.vk.api.sdk.objects.groups.responses.GetMembersFieldsResponse;
import com.vk.api.sdk.objects.users.Fields;

import java.util.HashMap;

import static java.lang.Thread.sleep;
public class ApiVK {
    private static final String CODE = "vk1.a.U3cMmu3ldTrj_HSDqTYN1HSICkZeVD4axxcZV-amtaj2YwuapFHHrNzNsbhQPmek5G-H6qCrkw07p_s02crkxc4MZB8YidCZJ53tP5pEmF6XFEHprpIKgFgmvlAx89z3fGyoBUu8hEwZCexr8yfpO3BqyAjosaooPxf2zQUApRu4KGh0nEgClt0p5dmcPcC9yHcMaNXnumVg4NTNduh4Zw";
    private static final long App_ID = 5180235;
    static TransportClient transportClient = new HttpTransportClient();
    private static final VkApiClient vk = new VkApiClient(transportClient);

    private static final UserActor actor = new UserActor(App_ID, CODE);

    public static HashMap<String, String> createMapCity() throws InterruptedException {
        final HashMap<String, String> cities = new HashMap<>();
        int offset = 0;
        int totalMem = 0;
        int maxMem = 1000;
        do {
            GetMembersFieldsResponse response = null;
            try {
                response = vk.groups().getMembersWithFields(actor, Fields.PERSONAL, Fields.CITY)
                        .groupId("215510262")
                        .offset(offset)
                        .count(maxMem)
                        .execute();
            } catch (ApiException | ClientException e) {
                throw new RuntimeException(e);
            }
            totalMem = response.getCount();
            offset += maxMem;
            for (UserXtrRole member : response.getItems()) {
                String name = member.getLastName() + " " + member.getFirstName();
                if (member.getCity() != null) {
                    String city = member.getCity().getTitle();
                    cities.put(name, city);
                }
            }
            sleep(1000);
        } while (offset < totalMem);
        return cities;
    }
}
