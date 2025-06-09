#include<iostream>
#include<bits/stdc++.h>

using namespace std;
class CSVDataProvider {
public:
    virtual string getCSVData() = 0;
    virtual ~CSVDataProvider() = default;
};

class JSONApi {
public:
    string getJson() {
        return R"({"name": "Tushar", "age": 24})";
    }
};

class XMLLogger {
public:
    string getXML() {
        return "<user><name>Tushar</name><age>24</age></user>";
    }
};

class ExcelFile {
public:
    string getXLSX() {
        return "EXCEL:BINARY:DATA"; // Just a placeholder
    }
};



class JsonAdapter : public CSVDataProvider {
    JSONApi* jsonApi;
public:
    JsonAdapter(JSONApi* api) : jsonApi(api) {}
    
    string getCSVData() override {
        // Simulate conversion from JSON to CSV
        string json = jsonApi->getJson();
        // Fake conversion
        return "name,age\nTushar,24";
    }
};

class XmlAdapter : public CSVDataProvider {
    XMLLogger* xmlLogger;
public:
    XmlAdapter(XMLLogger* logger) : xmlLogger(logger) {}

    string getCSVData() override {
        // Simulate conversion from XML to CSV
        string xml = xmlLogger->getXML();
        // Fake conversion
        return "name,age\nTushar,24";
    }
};

class ExcelAdapter : public CSVDataProvider {
    ExcelFile* excelFile;
public:
    ExcelAdapter(ExcelFile* file) : excelFile(file) {}

    string getCSVData() override {
        // Simulate conversion from Excel to CSV
        return "name,age\nTushar,24";
    }
};



class AnalyticsEngine {
public:
    void process(CSVDataProvider* provider) {
        string csv = provider->getCSVData();
        cout << "Processing CSV:\n" << csv << endl;
    }
};



int main() {
    AnalyticsEngine engine;

    JSONApi json;
    XmlAdapter xmlAdapter(new XMLLogger());
    ExcelAdapter excelAdapter(new ExcelFile());

    JsonAdapter jsonAdapter(&json);

    engine.process(&jsonAdapter);
    engine.process(&xmlAdapter);
    engine.process(&excelAdapter);

    return 0;
}

