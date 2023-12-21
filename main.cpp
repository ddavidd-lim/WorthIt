#include <iostream>
#include <curl/curl.h>
#include <stdlib.h>

int main() {
    // Initialize libcurl
    curl_global_init(CURL_GLOBAL_ALL);
    CURL* curl = curl_easy_init();

    if (curl) {
        // Set the API endpoint URL
        std::string url = "https://trackapi.nutritionix.com/v2/search/instant/";

        // Set the query for Taco Bell Beefy Melt
        std::string query = "?q=Taco Bell Beefy Melt";

        url += query;
        // Set your API key
        std::string api_key = "4132b917";

        // Set the request headers (using API key for authentication)
        struct curl_slist* headers = NULL;
        std::string auth_header = "x-app-id: " + api_key;
        headers = curl_slist_append(headers, auth_header.c_str());

        // Combine URL and query
        url += query;

        // Set additional options
        curl_easy_setopt(curl, CURLOPT_HTTPHEADER, headers);
        curl_easy_setopt(curl, CURLOPT_URL, url.c_str());

        // Perform the request
        CURLcode res = curl_easy_perform(curl);

        if (res != CURLE_OK) {
            std::cerr << "Failed to perform request: " << curl_easy_strerror(res) << std::endl;
        } else {
            // Request was successful, handle the response
            // You might want to add code here to handle the response (parsing JSON, etc.)
        }

        // Cleanup
        curl_easy_cleanup(curl);
        curl_slist_free_all(headers);
    }

    // Cleanup global libcurl resources
    curl_global_cleanup();

    return 0;
}
