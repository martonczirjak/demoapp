package com.plixapp.czirjak.plixapp.wilds.requests;

import com.android.volley.Response;
import com.plixapp.czirjak.plixapp.login.requests.LoginResponse;
import com.rainy.networkhelper.annotation.HeaderParam;
import com.rainy.networkhelper.annotation.RequestMethod;
import com.rainy.networkhelper.request.ParserRequest;
import com.rainy.networkhelper.response.ParsedResponse;

@RequestMethod(url = "http://hunter.plixapp.com/api/v1/master/wilds")
public class GetWildsRequest extends ParserRequest<WildResponse> {

    @HeaderParam(name = "Authorization")
    private String auth = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImI0YzZiOTM2NmY1NjgzZDM4NDgyZDBhNzhkMmNkOGY1MzQ4MjEyMzY1NGQ5OTU0YjhjYzhhZTQ5ZTY0NTAyMTViZTQ2OGRmMDhhMzczNDNiIn0.eyJhdWQiOiI1IiwianRpIjoiYjRjNmI5MzY2ZjU2ODNkMzg0ODJkMGE3OGQyY2Q4ZjUzNDgyMTIzNjU0ZDk5NTRiOGNjOGFlNDllNjQ1MDIxNWJlNDY4ZGYwOGEzNzM0M2IiLCJpYXQiOjE1NDE1OTE5NDAsIm5iZiI6MTU0MTU5MTk0MCwiZXhwIjoxNTczMTI3OTQwLCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.odFIkcH7HbF2zRSZVNw5LcBpyAtMmIhaojISSvw-O_odmF1pMVTN_vgtye7ZYN8G0SrbTZhMidmKft1zA4d-k0hXWdvpNHnQpO60RAIlDTyiXSy6e-EkRLZlDxAd48f-D26HBFXeRplGzaex4KgeRv21IhKm56JGktBqzmXmyNmK4phsxALuGWkoxCpfD5YCMBaZDTJfWy4mq56rvnoxPBk93QgrJkthn8P9FapQpCBWmv2wQcZPEdfM9xEeiCXDgDCb7R8PWO5ed9WJHeH_3YhA0IjMA4G_jVxsFKuh8PcBYMQVaBjKyEgd7_scLYK61YF7Hskah5qSs3NJVVS1aFRNBPlYBdi_TGObMt6yRWPMLICwcU_9dXFex-q-ZKGcSveLmmEll_jmOThsKA4_5M1C9p1NtNlMIUpx13OSNFTW1A8Kv42HvXDxKh3Erwgzupcxem9MTj7kohSvtm4ANMyJ2lrWhumRv6m2lvxgObCuciRRse-xxrqGdBjXbtKd51I8yzOlDqIiDViOOjtjO8VziXtLt5jOXYYdhcSayN6Xtg28v-hsr9UuxrXFwpx5uN5Qg-3tH2XDKl_018_cxWB7tX5j7IfCIRf3i3IAKF-Z0olItncJFr5az5w1xyuk6fQvtRjn29ZkaohqUeCEeZcMdlz-vT2JqmupJvFpZZI";

    @HeaderParam(name = "deviceid")
    private String deviceid = "95be3f2e-1d69-40f3-ba7a-3c515fa8ee52";

    @HeaderParam(name = "Accept")
    private String accept = "application/json";

    @HeaderParam(name = "Cache-Control")
    private String cacheControl = "no-cache";

    @HeaderParam(name = "Accept-Language")
    private String acceptlanguage = "hu";

    @HeaderParam(name = "hunterid")
    private String hunterid;

    @HeaderParam(name = "password")
    private String password;


    public GetWildsRequest(String hunterid, String password, Response.Listener<ParsedResponse<WildResponse>> listener, Response.ErrorListener errorListener) {
        super(listener, errorListener);
        this.hunterid = hunterid;
        this.password = password;
    }

}